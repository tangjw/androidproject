package zonsim.tangjunwei.android.dagger.activity;


import io.reactivex.functions.Consumer;
import zonsim.tangjunwei.android.dagger.net.UserManager;
import zonsim.tangjunwei.android.dagger.net.model.User;
import zonsim.tangjunwei.android.dagger.util.Validator;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

public class SplashActivityPresenter {
    
    public String username;
    private SplashActivity splashActivity;
    private Validator validator;
    private UserManager userManager;
    
    public SplashActivityPresenter(SplashActivity splashActivity, Validator validator, UserManager userManager) {
        this.splashActivity = splashActivity;
        this.validator = validator;
        this.userManager = userManager;
    }
    
    public void onShowRepositoryClick() {
        
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true);
            
            userManager.getUser(username)
                    .subscribe(new Consumer<User>() {
                        @Override
                        public void accept(User user) throws Exception {
                            splashActivity.showRepositoryListForUser(user);
                        }
                    });
            
            
        } else {
            splashActivity.showValidationError();
        }
        
    }
}
