package zonsim.tangjunwei.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/14.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public abstract class BaseFragment extends Fragment {
    
    protected AppCompatActivity mActivity;
    
    /**
     * 根view
     */
    protected View mRootView;
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AppCompatActivity) {
            mActivity = (AppCompatActivity) context;
        } else {
            throw new RuntimeException(context.toString() + "must extends AppCompatActivity!");
        }
        
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            initArguments(args);
        } else {
            Timber.e("getArguments() == null");
        }
    }
    
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        
        mRootView = inflater.inflate(getLayoutId(), container, false);
        
        init();
        
        return mRootView;
    }
    
    
    /**
     * 初始化参数
     */
    protected void initArguments(@NonNull Bundle args) {
    }
    
    protected abstract int getLayoutId();
    
    protected void init() {
    }
    
    
}
