package zonsim.tangjunwei.android.dagger.net;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import zonsim.tangjunwei.android.dagger.net.model.User;
import zonsim.tangjunwei.android.dagger.net.resp.UserResponse;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

public class UserManager {
    private GithubApi mGithubApi;
    
    public UserManager(GithubApi githubApi) {
        mGithubApi = githubApi;
    }
    
    public Observable<User> getUser(String username) {
        return mGithubApi.getUser(username)
                .map(new Function<UserResponse, User>() {
                    @Override
                    public User apply(UserResponse userResponse) throws Exception {
                        User user = new User();
                        user.login = userResponse.login;
                        user.id = userResponse.id;
                        user.url = userResponse.url;
                        user.email = userResponse.email;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
