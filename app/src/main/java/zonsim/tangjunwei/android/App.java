package zonsim.tangjunwei.android;

import android.app.Application;

import zonsim.tangjunwei.android.dagger.AppModule;
import zonsim.tangjunwei.android.dagger.DaggerNetComponent;
import zonsim.tangjunwei.android.dagger.NetComponent;
import zonsim.tangjunwei.android.dagger.NetModule;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/6.
 */

public class App extends Application {
    
    private NetComponent mNetComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://"))
                .build();
        
        
    }
    
    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
