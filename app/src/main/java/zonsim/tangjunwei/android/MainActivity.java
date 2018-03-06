package zonsim.tangjunwei.android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    
    @Inject
    OkHttpClient mOkHttpClient;
    
    @Inject
    SharedPreferences mSharedPreferences;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        App app = (App) getApplication();
        app.getNetComponent().inject(this);
    }
}
