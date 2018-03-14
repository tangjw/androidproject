package zonsim.tangjunwei.android.net.auth;

import javax.inject.Singleton;

import dagger.Component;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/13.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

@Singleton
@Component(modules = TokenAuthenticatorModule.class)
public interface TokenAuthenticatorComponent {
    
    TokenAuthenticator getTokenAuthenticator();
}
