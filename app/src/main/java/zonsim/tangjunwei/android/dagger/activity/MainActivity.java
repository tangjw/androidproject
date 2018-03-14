package zonsim.tangjunwei.android.dagger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zonsim.tangjunwei.android.NewsActivity;
import zonsim.tangjunwei.android.R;
import zonsim.tangjunwei.mvp.BaseNetworkView;

public class MainActivity extends AppCompatActivity implements BaseNetworkView {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
    }
    
    @Override
    public void show401Error() {
        
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
        startActivity(new Intent(this, NewsActivity.class));
    }
}
