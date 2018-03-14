package zonsim.tangjunwei.util.spreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/12.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

public class SPManager {
    
    private Context mContext;
    private final String sKey;
    
    public SPManager(Context context) {
        mContext = context;
        sKey = "zonsimtangjw" /*+ mContext.getResources().getString(R.string.app_name)*/;
    }
    
    
    public void setBoolean(String key, boolean value) {
        setBoolean("config", key, value);
    }
    
    public boolean getBoolean(String key, boolean defValue) {
        return getBoolean("config", key, defValue);
    }
    
    public String getString(String key, String defValue) {
        return getString("config", key, defValue);
    }
    
    public void setString(String key, String value) {
        setString("config", key, value);
    }
    
    public int getInt(String key, int defValue) {
        return getInt("config", key, defValue);
    }
    
    public void setInt(String key, int value) {
        setInt("config", key, value);
    }
    
    
    public boolean getBoolean(String name, String key, boolean defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }
    
    public void setBoolean(String name, String key, boolean value) {
        SharedPreferences sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }
    
    public String getString(String name, String key, String defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }
    
    public void setString(String name, String key, String value) {
        SharedPreferences sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }
    
    public int getInt(String name, String key, int defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }
    
    public void setInt(String name, String key, int value) {
        SharedPreferences sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }
    
    
    public void putSecure(String key, String value) {
        SecurePreferences securePreferences = new SecurePreferences(mContext, "usr", sKey, true);
        securePreferences.put(key, value);
    }
    
    public String getSecure(String key) {
        SecurePreferences securePreferences = new SecurePreferences(mContext, "usr", sKey, true);
        return securePreferences.getString(key);
    }
    
}
