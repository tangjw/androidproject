package zonsim.tangjunwei.android.nestedscroll;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import zonsim.tangjunwei.android.R;

public class ScrollingActivity extends AppCompatActivity {
    
    private CoordinatorLayout mCoordinatorLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
    
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        
    
        //"http://view.bug.cn/uc/2332016.html"

//        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.top);
//        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        WebView webView = (WebView) findViewById(R.id.webView);
    
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://m.17hbpx.com/html/news/detail/2150");
    
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
               // System.out.println("verticalOffset: " + verticalOffset);
            }
        });
        
        RecyclerView rv = findViewById(R.id.rv);
    
    
        rv.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add("item" + i);
        }
        rv.setAdapter(new MyAdapter(this, data));
     
        
    }
    
    public void top(View view) {
        Toast.makeText(this, "top", Toast.LENGTH_SHORT).show();
    }
    
    public void bottom(View view) {
        Toast.makeText(this, "bottom", Toast.LENGTH_SHORT).show();
    }
}
