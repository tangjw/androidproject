package zonsim.tangjunwei.network.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zonsim.tangjunwei.network.token.TokenInterceptor;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/12.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

@Module
public class TokenInterceptorModule {
    
    private String mToken;
    
    public TokenInterceptorModule(String token) {
        mToken = token;
    }
    
    @Singleton
    @Provides
    TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor(mToken);
        
    }
    
    
}
