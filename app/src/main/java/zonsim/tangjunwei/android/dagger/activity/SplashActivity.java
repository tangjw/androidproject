package zonsim.tangjunwei.android.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import zonsim.tangjunwei.android.R;
import zonsim.tangjunwei.android.dagger.app.DaggerApp;
import zonsim.tangjunwei.android.dagger.net.model.User;

/**
 * desc
 *
 * @author tangjunwei
 * @email tjwabc@gmail.com
 * Created by company-pc on 2018/3/8.
 */

public class SplashActivity extends BaseActivity {
    
    EditText etUsername;
    ProgressBar pbLoading;
    Button btnShowRepositories;
    
    
    
    @Override
    protected void setupComponent() {
    
    }
    
    @Override
    protected void setupCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.splash_activity);
        etUsername = findViewById(R.id.etUsername);
        pbLoading = findViewById(R.id.pbLoading);
        btnShowRepositories = findViewById(R.id.btnShowRepositories);
    }
    
    public void showLoading(boolean b) {
        Toast.makeText(this, b ? "..." : "===", Toast.LENGTH_SHORT).show();
    }
    
    public void showValidationError() {
        Toast.makeText(this, "不能为空！", Toast.LENGTH_SHORT).show();
    }
    
    public void showRepositoryListForUser(User user) {
        DaggerApp application = (DaggerApp) getApplication();
        
    }
}
