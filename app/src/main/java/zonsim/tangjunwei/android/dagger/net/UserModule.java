package zonsim.tangjunwei.android.dagger.net;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.android.dagger.net.model.User;

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
    
    @Singleton
    @Provides
    User providesUser() {
        return new User();
    }
    
    
}
