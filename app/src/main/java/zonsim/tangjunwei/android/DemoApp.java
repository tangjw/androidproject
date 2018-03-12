package zonsim.tangjunwei.android;

import android.app.Activity;

import zonsim.tangjunwei.android.net.ApiService;
import zonsim.tangjunwei.android.net.ApiServiceComponent;
import zonsim.tangjunwei.android.net.ApiServiceModule;
import zonsim.tangjunwei.android.net.DaggerApiServiceComponent;
import zonsim.tangjunwei.android.net.auth.TokenAuthenticator;
import zonsim.tangjunwei.app.BaseApp;
import zonsim.tangjunwei.app.BaseAppModule;
import zonsim.tangjunwei.network.di.OkHttpClientModule;
import zonsim.tangjunwei.network.di.RetrofitModule;
import zonsim.tangjunwei.network.di.TokenInterceptorModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

public class DemoApp extends BaseApp {
    
    private ApiServiceComponent mComponent;
    
    public static DemoApp get(Activity activity) {
        return (DemoApp) activity.getApplication();
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
    
        mComponent = DaggerApiServiceComponent.builder()
                .apiServiceModule(new ApiServiceModule())
                .baseAppModule(new BaseAppModule(this))
                .tokenInterceptorModule(new TokenInterceptorModule("token"))
                .okHttpClientModule(new OkHttpClientModule(new TokenAuthenticator()))
                .retrofitModule(new RetrofitModule("https://api.17hbpx.com"))
                .build();
    
    
        ApiService apiService1 = mComponent.getApiService();
    
        System.out.println(apiService1);
    
    
    }
    
    public ApiServiceComponent getComponent() {
        return mComponent;
    }
}
