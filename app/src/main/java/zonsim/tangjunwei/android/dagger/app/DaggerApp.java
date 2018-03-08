package zonsim.tangjunwei.android.dagger.app;

import android.annotation.SuppressLint;
import android.app.Application;


/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/8.
 */

@SuppressLint("Registered")
public class DaggerApp extends Application {
    
    private AppComponent mAppComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        
    }
    
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
