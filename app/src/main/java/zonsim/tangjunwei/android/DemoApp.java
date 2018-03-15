package zonsim.tangjunwei.android;

import android.app.Activity;

import okhttp3.Authenticator;
import timber.log.Timber;
import zonsim.tangjunwei.android.net.ApiServiceComponent;
import zonsim.tangjunwei.android.net.ApiServiceModule;
import zonsim.tangjunwei.android.net.DaggerApiServiceComponent;
import zonsim.tangjunwei.android.net.auth.DaggerTokenAuthenticatorComponent;
import zonsim.tangjunwei.android.net.auth.TokenAuthenticator;
import zonsim.tangjunwei.android.net.auth.TokenAuthenticatorModule;
import zonsim.tangjunwei.app.BaseApp;
import zonsim.tangjunwei.app.BaseAppModule;
import zonsim.tangjunwei.network.di.OkHttpClientModule;
import zonsim.tangjunwei.network.di.RetrofitModule;
import zonsim.tangjunwei.network.di.TokenInterceptorModule;
import zonsim.tangjunwei.network.scheduler.DaggerSchedulerProviderComponent;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

public class DemoApp extends BaseApp {
    
    private ApiServiceComponent mComponent;
    public String mBaseUrl = "https://api.17hbpx.com";
    private TokenAuthenticator mAuthenticator;
    
    public static DemoApp get(Activity activity) {
        return (DemoApp) getBaseApp(activity);
    }
    
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        initLogger();
        
        initAuthenticator();
        
        initApiService(mBaseUrl, mAuthenticator);
        
        
    }
    
    private void initAuthenticator() {
        mAuthenticator = DaggerTokenAuthenticatorComponent.builder()
                .baseAppModule(new BaseAppModule(this))
                .okHttpClientModule(new OkHttpClientModule())
                .tokenAuthenticatorModule(new TokenAuthenticatorModule(mBaseUrl))
                .build().getTokenAuthenticator();
    }
    
    
    private void initApiService(String baseUrl, Authenticator authenticator) {
        mComponent = DaggerApiServiceComponent.builder()
                .apiServiceModule(new ApiServiceModule())
                .baseAppModule(new BaseAppModule(this))
                .tokenInterceptorModule(new TokenInterceptorModule(null))
                .okHttpClientModule(new OkHttpClientModule(authenticator))
                .retrofitModule(new RetrofitModule(mBaseUrl))
                .schedulerProviderComponent(DaggerSchedulerProviderComponent.create())
                .build();
    }
    
    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
    
    public ApiServiceComponent getComponent() {
        return mComponent;
    }
    
    public void refreshToken(String token) {
        mComponent.getTokenInterceptor().setToken(token);
        setAuthToken(token);
    }
    
}
