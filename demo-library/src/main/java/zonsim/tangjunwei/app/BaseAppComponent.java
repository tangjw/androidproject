package zonsim.tangjunwei.app;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;
import zonsim.tangjunwei.network.di.RetrofitModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

/*@Singleton
@Component(modules = {RetrofitModule.class, BaseAppModule.class})*/
public interface BaseAppComponent {
    Retrofit getRetrofit();
    
    
}
