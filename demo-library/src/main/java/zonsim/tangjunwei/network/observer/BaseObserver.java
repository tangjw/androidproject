package zonsim.tangjunwei.network.observer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import zonsim.tangjunwei.mvp.BaseNetworkView;
import zonsim.tangjunwei.network.api.ApiResponse;
import zonsim.tangjunwei.network.api.ErrorArguments;
import zonsim.tangjunwei.util.Strings;


public class BaseObserver<T> implements Observer<ApiResponse<T>> {
    
    private final String TAG = getClass().getSimpleName();
    private BaseNetworkView mView;
    
    public BaseObserver(BaseNetworkView view) {
        mView = view;
    }
    
    public BaseObserver() {
        
    }
    
    @Override
    public void onSubscribe(Disposable d) {
    
    }
    
    @Override
    public void onNext(ApiResponse<T> response) {
        
        if (response == null) {
            onFail("response为null");
            return;
        }
        
        int status = response.getStatus();
        if (status >= 200 && status < 300) {
            if (response.getData() != null) {
                onSuccess(response.getData());
            } else {
                onFail("data为null");
            }
        } else {
            onFail("HTTP ERROR");
        }
        
    }
    
    protected void onSuccess(@NonNull T data) {
        
    }
    
    protected void onFail(String msg) {
        if (mView != null) {
            //mView.hideProgressView();
            mView.toastMsg(msg);
        }
    }
    
    @Override
    public void onError(Throwable e) {
        
        if (e instanceof HttpException) {
            HttpException exception = (HttpException) e;
            Response response = exception.response();
            Converter<ResponseBody, ?> converter = GsonConverterFactory.create()
                    .responseBodyConverter(ApiResponse.class, null, null);
            
            try {
                ApiResponse error = (ApiResponse) converter.convert(response.errorBody());
                switch (error.getStatus()) {
                    case 401: // 登录失效
                        http401();
                        break;
                    
                    case 499: //校验手机号 邮箱格式等等
                        
                        try {
                            Gson gson = new Gson();
                            List<ErrorArguments> data = gson.fromJson(gson.toJson(error.getData()), new TypeToken<List<ErrorArguments>>() {
                            }.getType());
                            if (data != null && data.size() > 0) {
                                onFail(data.get(0).getMessage() + "");
                            }
                            break;
                        } catch (JsonSyntaxException ignored) {
                        
                        }
                        onFail("参数错误");
                        break;
                    
                    case 500:
                        String msg = "未知业务错误";
                        if (error.getData() != null) {
                            msg = error.getData().toString();
                        } else if (error.getMessage() != null) {
                            msg = error.getMessage();
                        } else if (error.getError() != null) {
                            msg = error.getError();
                        }
                        onFail(msg);
                        break;
                }
                
                return;
            } catch (IOException ignored) {
                //ignored
            }
            return;
        }
        
        String message = Strings.nullToEmpty(e.getMessage());
        
        // A network or conversion error happened
        if (message.contains("Expected BEGIN_OBJECT but was")) {
            onFail("json数据异常");
        } else if (message.contains("timeout")) {
            onFail("连接超时");
        } else if (message.contains("failed to connect")) {
            onFail("无法连接到服务器");
        } else {
            onFail("未知异常" + message);
        }
        
        
        // We don't know what happened. We need to simply convert to an unknown error
        // ...
        // ToastUtils.clear(App.getContext(), e.getMessage());
        
    }
    
    private void http401() {
        if (mView != null) {
            mView.show401Error();
        }
    }
    
    @Override
    public void onComplete() {
    
    }
    
}
