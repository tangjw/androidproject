package zonsim.tangjunwei.android.net;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import zonsim.tangjunwei.app.BaseAppModule;
import zonsim.tangjunwei.network.di.RetrofitModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

@Module(includes = {RetrofitModule.class})
public class ApiServiceModule {
    
    @Singleton
    @Provides
    ApiService provideApiService(@Named("with_auth") Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
    
}
