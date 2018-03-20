package zonsim.tangjunwei.android;

import android.support.annotation.NonNull;
import android.view.View;

import zonsim.tangjunwei.android.base.BaseTitleActivity;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/13.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class NewsActivity extends BaseTitleActivity {
    
    @Override
    protected int getMainLayoutId() {
        return R.layout.news_activity;
    }
    
    @Override
    protected void initMain(@NonNull View rootView) {
        
        mTvTitle.setText("新闻资讯");
        showLoading(null);
       /* mApiService.getHomeInfos()
                .delay(20000L, TimeUnit.MILLISECONDS)
                .subscribeOn(mSchedulers.io())
                .observeOn(mSchedulers.ui())
                .subscribe(new BaseObserver<HomeResp>(this) {
                    @Override
                    protected void onSuccess(HomeResp data) {
                        super.onSuccess(data);
                        hideLoading();
                    }
                    
                    @Override
                    protected void onFail(String msg) {
                        super.onFail(msg);
                        showNetworkError();
                    }
                });*/
    }
}

