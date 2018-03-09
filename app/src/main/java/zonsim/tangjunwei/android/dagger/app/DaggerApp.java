package zonsim.tangjunwei.android.dagger.app;

import android.app.Application;

import zonsim.tangjunwei.android.dagger.net.UserComponent;
import zonsim.tangjunwei.android.dagger.net.UserModule;
import zonsim.tangjunwei.android.dagger.net.model.User;


/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/8.
 */

public class DaggerApp extends Application {
    
    private AppComponent mAppComponent;
    private UserComponent mUserComponent;
    
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
    
    public UserComponent createUserComponent(User user) {
        mUserComponent = mAppComponent.plus(new UserModule(user));
        return mUserComponent;
    }
    
    public void releaseUserComponent() {
        mUserComponent = null;
    }
    public UserComponent getUserComponent() {
        return mUserComponent;
    }
    
}
