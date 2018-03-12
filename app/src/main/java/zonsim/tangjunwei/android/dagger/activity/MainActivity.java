package zonsim.tangjunwei.android.dagger.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zonsim.tangjunwei.android.DemoApp;
import zonsim.tangjunwei.android.R;
import zonsim.tangjunwei.android.net.ApiService;
import zonsim.tangjunwei.android.net.ApiServiceComponent;
import zonsim.tangjunwei.android.net.entity.HomeResp;
import zonsim.tangjunwei.mvp.BaseNetworkView;
import zonsim.tangjunwei.network.observer.BaseObserver;
import zonsim.tangjunwei.network.token.TokenInterceptor;

public class MainActivity extends AppCompatActivity implements BaseNetworkView {
    
    
    private ApiService mApiService;
    private TokenInterceptor mTokenInterceptor;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        ApiServiceComponent component = DemoApp.get(this).getComponent();
    
        mApiService = component.getApiService();
        mApiService.getHomeInfos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomeResp>(this) {
                
                });
    
        mTokenInterceptor = component.getTokenInterceptor();
        System.out.println("token: " + mTokenInterceptor.getToken());
    
    
    }
    
    @Override
    public void show401Error() {
        
    }
    
    @Override
    public void networkError() {
        
    }
    
    @Override
    public void showEmptyError() {
        
    }
    
    @Override
    public void toastMsg(String message) {
        
    }
    
    @Override
    public void showProgressView(String message) {
        
    }
    
    @Override
    public void hideProgressView() {
        
    }
    
    public void click(View view) {
        mTokenInterceptor.setToken("12312312312123");
        System.out.println("token: " + mTokenInterceptor.getToken());
        mApiService.getHomeInfos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomeResp>(this) {
                    
                });
    }
}
