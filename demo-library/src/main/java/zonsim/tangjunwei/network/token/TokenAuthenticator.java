package zonsim.tangjunwei.network.token;

import android.app.Application;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * token认证器，认证失败后根据 app_secret 获取新的token
 * Created by tang-jw on 9/16.
 */
public class TokenAuthenticator implements Authenticator {
    
    //    private final String mSecret;
//    private final ServiceManager mServiceManager;
    private String mAppToken;
    
    private Application mApplication;
    
    public TokenAuthenticator(Application context) {
        mApplication = context;
    }
    
    /*public TokenAuthenticator(@NonNull String secret, @NonNull ServiceManager serviceManager) {
        mSecret = secret;
        mServiceManager = serviceManager;
    }*/
    
    
    @Override
    public Request authenticate(Route route, Response response) {
        
        
        /*ApiService apiService = mServiceManager.getTokenApiService();
        Observable<ApiResponse<LoginResp>> dsdsd = apiService
                .refreshToken1(mSecret);
        
        Call<LoginResp> refreshToken = apiService.refreshToken2(mSecret);
        
        try {
            retrofit2.Response<LoginResp> response1 = refreshToken.execute();
            LoginResp body = response1.body();
            if (body != null) {
                String appSecret = body.getAppSecret();
            }
          
    
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        
        
        mServiceManager.getTokenApiService()
                .refreshToken1(mSecret)
                .subscribe(new BaseObserver<LoginResp>() {
                    @Override
                    protected void onSuccess(LoginResp data) {
                        mAppToken = data.getAppToken();
                    }
                    
                    @Override
                    public void onError(Throwable e) {
                        //super.onError(e);
                    }
                });
        
        if (mAppToken != null) {
            //secret有效时不更新
            mServiceManager.saveSecret(mSecret, mAppToken);
            return response.request().newBuilder()
                    .header("Authorization", mAppToken)
                    .build();
        } else {
            return null;
        }*/
        
        return null;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     /*ApiService service = mServiceManager.getTokenApiService();
        try {
            retrofit2.Response<ApiResponse<LoginResp>> execute = service.refreshToken(mSecret).execute();
            ApiResponse<LoginResp> respApiResponse = execute.body();
            
            if (respApiResponse != null) {
                LoginResp data = respApiResponse.getData();
                //secret有效时不更新
                mServiceManager.saveSecret(null, data.getAppToken());
                return response.request().newBuilder()
                        .header("Authorization", data.getAppToken())
                        .build();
            }
            
            mServiceManager.startLogin();
            return null;
        } catch (IOException ignored) {
            mServiceManager.startLogin();
            return null;
        }*/
    
    
}
