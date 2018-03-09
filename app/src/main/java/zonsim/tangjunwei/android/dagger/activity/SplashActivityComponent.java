package zonsim.tangjunwei.android.dagger.activity;

import javax.inject.Singleton;

import dagger.Subcomponent;
import zonsim.tangjunwei.android.dagger.scope.ActivityScope;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

@ActivityScope
@Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {
    void inject(SplashActivity splashActivity);
}
