package zonsim.tangjunwei.android.dagger.util;

import android.text.TextUtils;

/**
 * 验证所输入的用户名是否为null “”
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

public class Validator {
    
    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }
}
