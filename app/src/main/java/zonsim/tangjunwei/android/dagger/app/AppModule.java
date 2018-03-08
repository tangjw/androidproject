package zonsim.tangjunwei.android.dagger.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.android.dagger.util.Validator;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/6.
 */

@Module
public class AppModule {
    
    private Application mApplication;
    
    public AppModule(Application application) {
        mApplication = application;
    }
    
    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
    
    @Provides
    @Singleton
    Validator providesValidator() {
        return new Validator();
    }
    
}
