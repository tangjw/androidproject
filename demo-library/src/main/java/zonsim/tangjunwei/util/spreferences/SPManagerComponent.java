package zonsim.tangjunwei.util.spreferences;

import javax.inject.Singleton;

import dagger.Component;
import zonsim.tangjunwei.app.BaseAppModule;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/13.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

@Singleton
@Component(modules = {SPManagerModule.class, BaseAppModule.class})
public interface SPManagerComponent {
    SPManager getSPManager();
}
