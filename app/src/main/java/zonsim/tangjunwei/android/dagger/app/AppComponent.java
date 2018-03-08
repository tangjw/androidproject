package zonsim.tangjunwei.android.dagger.app;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.android.dagger.activity.SplashActivity;
import zonsim.tangjunwei.android.dagger.net.GithubApiModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

@Singleton
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {
    
    //    SplashActivityComponent plus(SplashActivityModule splashActivityModule);
//    
//    UserComponent plus(UserModule userModule);
    void inject(SplashActivity splashActivity);
}