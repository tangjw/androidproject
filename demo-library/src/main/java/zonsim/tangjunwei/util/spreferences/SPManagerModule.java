package zonsim.tangjunwei.util.spreferences;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.app.BaseAppModule;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/13.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

@Module(includes = {BaseAppModule.class})
public class SPManagerModule {
    
    @Singleton
    @Provides
    SPManager providerSPManager(Application application) {
        return new SPManager(application);
    }
    
    
}
