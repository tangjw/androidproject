package zonsim.tangjunwei.android.net;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.network.di.TokenInterceptorModule;
import zonsim.tangjunwei.network.scheduler.SchedulerProvider;
import zonsim.tangjunwei.network.scheduler.SchedulerProviderComponent;
import zonsim.tangjunwei.network.token.TokenInterceptor;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

@Singleton
@Component(modules = {ApiServiceModule.class, TokenInterceptorModule.class}, dependencies = {SchedulerProviderComponent.class})
public interface ApiServiceComponent {
    
    ApiService getApiService();
    
    /**
     * application级别单例，方便使用 set 方法修改token
     */
    TokenInterceptor getTokenInterceptor();
    
    SchedulerProvider getSchedulerProvider();
}
