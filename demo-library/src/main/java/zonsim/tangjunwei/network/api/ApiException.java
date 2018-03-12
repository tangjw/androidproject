package zonsim.tangjunwei.network.api;

import android.support.annotation.NonNull;

/**
 * api 异常
 * Created by tang-jw on 10/30.
 */

public class ApiException extends RuntimeException {
    
    
    private int mCode;
    private String mMessage;
    
    public ApiException(int code, @NonNull String message) {
        super(message);
        mCode = code;
        mMessage = message;
    }
    
    public int getCode() {
        return mCode;
    }
    
    public void setCode(int code) {
        mCode = code;
    }
    
    @Override
    public String getMessage() {
        return mMessage;
    }
    
    public void setMessage(String message) {
        mMessage = message;
    }
}
