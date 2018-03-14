package zonsim.tangjunwei.android.net.auth;

import android.app.Application;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zonsim.tangjunwei.android.DemoApp;
import zonsim.tangjunwei.android.net.ApiService;
import zonsim.tangjunwei.android.net.entity.LoginResp;
import zonsim.tangjunwei.network.api.ApiResponse;

/**
 * token认证器 http 401 时拦截刷新token 继续请求
 * <p>
 * Created by tangjunwei on 2018/3/12.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class TokenAuthenticator implements Authenticator {
    
    private final ApiService mApiService;
    private final DemoApp demoApp;
    
    public TokenAuthenticator(String baseUrl, Application baseApp, OkHttpClient okHttpClient) {
        demoApp = (DemoApp) baseApp;
        mApiService = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(ApiService.class);
    }
    
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
    
        ApiResponse<LoginResp> apiResponse = mApiService.refreshToken(demoApp.getAuthSecret()).body();
    
        if (apiResponse != null) {
            String appToken = apiResponse.getData().getAppToken();
            demoApp.refreshToken(appToken);
            return response.request().newBuilder()
                    .header("Authorization", demoApp.getAuthToken())
                    .build();
        
        }
        
        return null;
    }
}
