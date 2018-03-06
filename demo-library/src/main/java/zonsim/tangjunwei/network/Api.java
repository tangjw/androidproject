package zonsim.tangjunwei.network;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 所有的接口
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/6.
 */

public interface Api {
    
    String HOST_URL = "https://api.github.com/";
    
    @GET("v1/index")
    Observable<ApiResp<Object>> testIndex();
}
