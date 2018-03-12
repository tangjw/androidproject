package zonsim.tangjunwei.network.api;

/**
 * 接口Response 统一的最外层 包含code，message 和 T data 等
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by tang-jw on 2018/3/6.
 */

@SuppressWarnings("public")
public class ApiResp<T> {
    
    private int code;
    
    private String message;
    
    private T data;
    
}
