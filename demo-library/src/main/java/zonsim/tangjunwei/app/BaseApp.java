package zonsim.tangjunwei.app;

import android.app.Activity;
import android.app.Application;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/10.
 */

public class BaseApp extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        
    }
    
    public static BaseApp get(Activity activity) {
        return (BaseApp) activity.getApplication();
    }
    
    public static String getAuthToken() {
        return "token";
    }
}
