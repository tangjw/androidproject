package zonsim.tangjunwei.android.net;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.app.BaseAppComponent;
import zonsim.tangjunwei.app.BaseAppModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

@Singleton
@Component(dependencies = {BaseAppComponent.class})
public interface ApiServiceComponent {
    ApiService getApiService();
}
