package zonsim.tangjunwei.android.dagger.net;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.android.dagger.net.model.User;
import zonsim.tangjunwei.android.dagger.scope.UserScope;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

@Module
public class UserModule {
    
    private User mUser;
    
    public UserModule(User user) {
        mUser = user;
    }
    
    @UserScope
    @Provides
    User providesUser() {
        return new User();
    }
    
    
}
