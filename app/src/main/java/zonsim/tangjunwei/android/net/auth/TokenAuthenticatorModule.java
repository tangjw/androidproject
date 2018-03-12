package zonsim.tangjunwei.android.net.auth;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.android.net.ApiServiceModule;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/12.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
@Module(includes = {ApiServiceModule.class})
public class TokenAuthenticatorModule {
    
    @Provides
    TokenAuthenticator tokenAuthenticator() {
        return new TokenAuthenticator();
    }
    
}
