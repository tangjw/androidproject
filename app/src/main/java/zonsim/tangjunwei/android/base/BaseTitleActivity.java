package zonsim.tangjunwei.android.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import zonsim.tangjunwei.android.R;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/14.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public abstract class BaseTitleActivity extends BaseNetActivity {
    
    protected TextView mTvTitle;
    private FrameLayout mFlContainer;
    private View mLoadView;
    private View mPbLoading;
    private View mLlLoadEmpty;
    private View mLlLoadError;
    
    @Override
    protected int getContentViewId() {
        return R.layout.base_title_activity;
    }
    
    @Override
    protected void init() {
        initToolbar((Toolbar) findViewById(R.id.toolbar));
        mTvTitle = findViewById(R.id.tv_toolbar_title);
        mFlContainer = findViewById(R.id.fl_container);
        mLoadView = getLayoutInflater().inflate(R.layout.loading_layout, null);
        mPbLoading = mLoadView.findViewById(R.id.load_pb_loading);
        mLlLoadEmpty = mLoadView.findViewById(R.id.load_ll_empty);
        mLlLoadError = mLoadView.findViewById(R.id.load_ll_error);
        super.init();
        View rootView = getLayoutInflater().inflate(getMainLayoutId(), null);
        mFlContainer.addView(rootView);
        initMain(rootView);
    }
    
    /**
     * 设置 toolbar ，默认已设置了返回键
     */
    protected void initToolbar(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.base_title_toolbar_back_icon);
        toolbar.setContentInsetStartWithNavigation(0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick();
            }
        });
    }
    
    /**
     * 点击返回键 默认 finish
     */
    protected void onBackClick() {
        finish();
    }
    
    protected abstract int getMainLayoutId();
    
    protected abstract void initMain(@NonNull View rootView);
    
    protected void showNetworkError() {
        if (mFlContainer.getChildCount() == 2) {
            mPbLoading.setVisibility(View.GONE);
            mLlLoadEmpty.setVisibility(View.GONE);
            mLlLoadError.setVisibility(View.VISIBLE);
        }
    }
    
    protected void showEmptyError() {
        if (mFlContainer.getChildCount() == 2) {
            mPbLoading.setVisibility(View.GONE);
            mLlLoadError.setVisibility(View.GONE);
            mLlLoadEmpty.setVisibility(View.VISIBLE);
        }
    }
    
    protected void showLoading(String message) {
        if (mFlContainer.getChildCount() == 1) {
            mFlContainer.addView(mLoadView);
            mPbLoading.setVisibility(View.VISIBLE);
            mLlLoadError.setVisibility(View.GONE);
            mLlLoadEmpty.setVisibility(View.GONE);
        }
    }
    
    protected void hideLoading() {
        if (mFlContainer.getChildCount() == 2) {
            mFlContainer.removeViewAt(1);
        }
    }
    
    
}
