package zonsim.tangjunwei.network.token;


import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import zonsim.tangjunwei.app.BaseApp;
import zonsim.tangjunwei.util.Strings;

/**
 * token 拦截器，为每次网络请求添加token
 * Created by tang-jw on 9/16.
 */
public class TokenInterceptor implements Interceptor {
    
    @Override
    public Response intercept(Chain chain) throws IOException {
        
        String mToken = BaseApp.getAuthToken();
        
        final Request originalRequest = chain.request();
        
        if (Strings.isNullOrEmpty(mToken) || originalRequest.header("Authorization") != null) {
            return chain.proceed(originalRequest);
        }
        
        Request request = originalRequest.newBuilder()
                .header("Authorization", mToken)
                .build();
        return chain.proceed(request);
    }
    
}
