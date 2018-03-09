package zonsim.tangjunwei.android.dagger.net;

import javax.inject.Singleton;

import dagger.Subcomponent;
import zonsim.tangjunwei.android.dagger.scope.UserScope;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    
    
}
