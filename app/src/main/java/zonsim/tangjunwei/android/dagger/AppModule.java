package zonsim.tangjunwei.android.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/6.
 */

@Module
public class AppModule {
    
    Application mApplication;
    
    public AppModule(Application application) {
        mApplication = application;
    }
    
    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
