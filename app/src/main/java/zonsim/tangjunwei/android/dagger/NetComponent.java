package zonsim.tangjunwei.android.dagger;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.android.MainActivity;

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
