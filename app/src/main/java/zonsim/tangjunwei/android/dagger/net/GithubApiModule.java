package zonsim.tangjunwei.android.dagger.net;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zonsim.tangjunwei.android.BuildConfig;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

@Module
public class GithubApiModule {
    
    @Provides
    @Singleton
    public OkHttpClient providersOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        
        return builder.build();
    }
    
    
    @Provides
    @Singleton
    public Retrofit provideRestAdapter(Application application, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }
    
    @Provides
    @Singleton
    public GithubApi providersGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }
    
    @Provides
    @Singleton
    public UserManager providesUserManager(GithubApi githubApi) {
        return new UserManager(githubApi);
    }
    
}
