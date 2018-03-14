package zonsim.tangjunwei.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zonsim.tangjunwei.mvp.BaseView;
import zonsim.tangjunwei.util.ToastUtils;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/13.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    
    protected ProgressDialog mProgressDialog;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleSavedInstanceState(savedInstanceState);
        setContentView(getContentViewId());
        init();
    }
    
    /**
     * 处理 savedInstanceState
     */
    protected void handleSavedInstanceState(@Nullable Bundle savedInstanceState) {
    
    }
    
    /**
     * 返回 layout id
     */
    protected abstract int getContentViewId();
    
    /**
     * initView initData等等
     */
    protected abstract void init();
    
    
    @Override
    public void toastMsg(String message) {
        ToastUtils.show(this, message);
    }
    
    @Override
    public void showProgressView(String message) {
    
    }
    
    @Override
    public void hideProgressView() {
    
    }
}
