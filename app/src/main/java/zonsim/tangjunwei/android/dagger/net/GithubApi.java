package zonsim.tangjunwei.android.dagger.net;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zonsim.tangjunwei.android.dagger.net.resp.RepositoryResponse;
import zonsim.tangjunwei.android.dagger.net.resp.UserResponse;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by home-pc on 2018/3/8.
 */

public interface GithubApi {
    
    @GET("/users/{username}")
    Observable<UserResponse> getUser(@Path("username") String username);
    
    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(@Path("username") String username);
}
