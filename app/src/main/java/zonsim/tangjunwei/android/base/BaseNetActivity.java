package zonsim.tangjunwei.android.base;

import zonsim.tangjunwei.android.DemoApp;
import zonsim.tangjunwei.android.net.ApiService;
import zonsim.tangjunwei.android.net.ApiServiceComponent;
import zonsim.tangjunwei.base.BaseActivity;
import zonsim.tangjunwei.mvp.BaseNetworkView;
import zonsim.tangjunwei.network.scheduler.SchedulerProvider;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/13.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public abstract class BaseNetActivity extends BaseActivity implements BaseNetworkView {
    
    protected ApiService mApiService;
    protected SchedulerProvider mSchedulers;
    
    @Override
    protected void init() {
        ApiServiceComponent component = DemoApp.get(this).getComponent();
        mApiService = component.getApiService();
        mSchedulers = component.getSchedulerProvider();
        
    }
    
    @Override
    public void show401Error() {
        //startActivity(new Intent(this,LoginActivity.class));
        toastMsg("需要登录");
    }
    
}
