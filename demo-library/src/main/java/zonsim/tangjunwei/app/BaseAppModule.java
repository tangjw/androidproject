package zonsim.tangjunwei.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/10.
 */

@Module
public class BaseAppModule {
    
    private Application mApplication;
    
    public BaseAppModule(Application application) {
        mApplication = application;
    }
    
    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }
    
    
}
