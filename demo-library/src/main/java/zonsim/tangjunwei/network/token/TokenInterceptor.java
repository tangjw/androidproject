package zonsim.tangjunwei.network.token;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import zonsim.tangjunwei.util.Strings;

/**
 * token 拦截器，为每次网络请求添加token
 * Created by tang-jw on 9/16.
 */
public class TokenInterceptor implements Interceptor {
    
    private String mToken;
    
    public TokenInterceptor(String token) {
        mToken = token;
    }
    
    public String getToken() {
        return mToken;
    }
    
    public void setToken(String token) {
        mToken = token;
    }
    
    @Override
    public Response intercept(Chain chain) throws IOException {
        
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
