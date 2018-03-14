package zonsim.tangjunwei.android.net.auth;

import android.app.Application;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import zonsim.tangjunwei.network.di.OkHttpClientModule;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/12.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
@Module(includes = {OkHttpClientModule.class})
public class TokenAuthenticatorModule {
    
    private final String mBaseUrl;
    
    public TokenAuthenticatorModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }
    
    @Provides
    TokenAuthenticator tokenAuthenticator(Application application, @Named("without_auth") OkHttpClient okHttpClient) {
        return new TokenAuthenticator(mBaseUrl, application, okHttpClient);
    }
}
