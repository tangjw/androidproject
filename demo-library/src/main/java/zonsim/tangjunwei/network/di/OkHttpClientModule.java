package zonsim.tangjunwei.network.di;

import android.app.Application;
import android.content.Context;


import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import zonsim.tangjunwei.app.BaseAppModule;
import zonsim.tangjunwei.network.cookie.CookiesManager;
import zonsim.tangjunwei.network.token.TokenAuthenticator;
import zonsim.tangjunwei.network.token.TokenInterceptor;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/11.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

@Module(includes = {BaseAppModule.class})
public class OkHttpClientModule {
    
    Authenticator mAuthenticator;
    
    public OkHttpClientModule(Authenticator authenticator) {
        mAuthenticator = authenticator;
    }
    
    @Named("with_authenticator")
    @Provides
    public OkHttpClient okHttpClient(
            TokenInterceptor tokenInterceptor,
            Cache cache,
            HttpLoggingInterceptor logInterceptor,
            CookiesManager cookiesManager) {
        
        return new OkHttpClient().newBuilder()
                .addInterceptor(tokenInterceptor)
                .authenticator(mAuthenticator)
                .cache(cache)
                .addInterceptor(logInterceptor)
                .cookieJar(cookiesManager)
                .build();
    }
    
    @Named("without_authenticator")
    @Provides
    public OkHttpClient okHttpClientNoAuth(
            TokenInterceptor tokenInterceptor,
            Cache cache,
            HttpLoggingInterceptor logInterceptor,
            CookiesManager cookiesManager) {
        
        return new OkHttpClient().newBuilder()
                .addInterceptor(tokenInterceptor)
                .cache(cache)
                .addInterceptor(logInterceptor)
                .cookieJar(cookiesManager)
                .build();
    }
    
    @Provides
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10 MB
    }
    
    
    @Singleton
    @Provides
    public File file(Application context) {
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdirs();
        return file;
    }
    
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //Timber.d(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
    
    
    @Singleton
    @Provides
    public CookiesManager provideCookiesManager(Application context) {
        return new CookiesManager(context);
    }
    
    @Provides
    public TokenInterceptor provideTokenInterceptor() {
        return new TokenInterceptor();
    }
    
}
