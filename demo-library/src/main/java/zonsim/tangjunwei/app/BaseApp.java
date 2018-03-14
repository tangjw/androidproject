package zonsim.tangjunwei.app;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;

import zonsim.tangjunwei.util.spreferences.DaggerSPManagerComponent;
import zonsim.tangjunwei.util.spreferences.SPManager;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/10.
 */

public class BaseApp extends Application {
    
    protected SPManager mSPManager;
    
    protected String mToken;
    
    private String mSecret;
    
    @Override
    public void onCreate() {
        super.onCreate();
    
        mSPManager = DaggerSPManagerComponent.builder().baseAppModule(new BaseAppModule(this)).build().getSPManager();
        
    }
    
    
    public static BaseApp getBaseApp(Activity activity) {
        return (BaseApp) activity.getApplication();
    }
    
    public String getAuthToken() {
        if (TextUtils.isEmpty(mToken)) {
            mToken = mSPManager.getSecure("auth_token");
        }
        return mToken;
    }
    
    public String getAuthSecret() {
        if (TextUtils.isEmpty(mSecret)) {
            mSecret = mSPManager.getSecure("auth_secret");
        }
        return mSecret;
    }
    
    public void setAuthToken(String token) {
        mToken = token;
        mSPManager.putSecure("auth_token", token);
    }
    
    public void setAuthSecret(String secret) {
        mSecret = secret;
        mSPManager.putSecure("auth_secret", secret);
    }
    
    
}
