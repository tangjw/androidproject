package zonsim.tangjunwei.android.dagger.activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.android.dagger.net.UserManager;
import zonsim.tangjunwei.android.dagger.scope.ActivityScope;
import zonsim.tangjunwei.android.dagger.util.Validator;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

@Module
public class SplashActivityModule {
    
    private SplashActivity mSplashActivity;
    
    public SplashActivityModule(SplashActivity splashActivity) {
        mSplashActivity = splashActivity;
    }
    
    @Provides
    @ActivityScope
    SplashActivity providesSplashActivity() {
        return mSplashActivity;
    }
    
    @Provides
    @ActivityScope
    SplashActivityPresenter providesSplashActivityPresenter(Validator validator, UserManager userManager) {
        return new SplashActivityPresenter(mSplashActivity, validator, userManager);
    }
}
