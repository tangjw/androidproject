package zonsim.tangjunwei.network.scheduler;

import javax.inject.Singleton;

import dagger.Component;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

@Singleton
@Component
public interface SchedulerProviderComponent {
    SchedulerProvider getSchedulerProvider();
}
