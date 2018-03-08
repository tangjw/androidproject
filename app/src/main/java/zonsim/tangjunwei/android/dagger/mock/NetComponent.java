package zonsim.tangjunwei.android.dagger.mock;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.android.dagger.activity.MainActivity;
import zonsim.tangjunwei.android.dagger.app.AppModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/6.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    
    void inject(MainActivity mainActivity);
    
}
