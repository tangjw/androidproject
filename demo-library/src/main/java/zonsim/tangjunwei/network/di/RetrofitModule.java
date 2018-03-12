package zonsim.tangjunwei.network.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

@Module(includes = {OkHttpClientModule.class})
public class RetrofitModule {
    
    private String mBaseUrl;
    
    public RetrofitModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }
    
    
    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(mBaseUrl)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }
    
    @Provides
    Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
    
    @Provides
    GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
    
    @Provides
    RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }
}
