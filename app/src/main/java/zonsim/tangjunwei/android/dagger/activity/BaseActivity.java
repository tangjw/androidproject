package zonsim.tangjunwei.android.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
        setupCreate(savedInstanceState);
    }
    
    protected abstract void setupComponent();
    
    protected abstract void setupCreate(@Nullable Bundle savedInstanceState);
}
