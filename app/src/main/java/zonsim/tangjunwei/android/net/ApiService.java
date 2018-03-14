package zonsim.tangjunwei.android.net;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import zonsim.tangjunwei.android.net.entity.HomeResp;
import zonsim.tangjunwei.android.net.entity.LoginResp;
import zonsim.tangjunwei.network.api.ApiResponse;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/12.
 */

public interface ApiService {
    
    @GET("/v1/html/home/list")
    Observable<ApiResponse<HomeResp>> getHomeInfos();
    
    @FormUrlEncoded
    @POST("/v1/auth/token")
    Response<ApiResponse<LoginResp>> refreshToken(@Field("appSecret") String appSecret);
    
}
