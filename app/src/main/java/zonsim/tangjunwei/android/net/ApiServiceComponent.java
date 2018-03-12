package zonsim.tangjunwei.android.net;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.network.di.TokenInterceptorModule;
import zonsim.tangjunwei.network.token.TokenInterceptor;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

@Singleton
@Component(modules = {ApiServiceModule.class, TokenInterceptorModule.class})
public interface ApiServiceComponent {
    ApiService getApiService();
    
    TokenInterceptor getTokenInterceptor();
    
}
