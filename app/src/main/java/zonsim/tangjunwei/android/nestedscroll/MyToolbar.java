package zonsim.tangjunwei.android.nestedscroll;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * ^-^
 * Created by tang-jw on 2018/3/2.
 */

public class MyToolbar extends Toolbar {
    
    public MyToolbar(Context context) {
        super(context);
        setPaddingTop();
    }
    
    public MyToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPaddingTop();
    }
    
    public MyToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setPaddingTop();
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + getStatusBarHeight());
        }
    }
    
    private void setPaddingTop() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setPadding(getPaddingLeft(), getPaddingTop() + getStatusBarHeight(), getPaddingRight(), getPaddingBottom());
        }
    }
    
   /* private int getPaddingTops() {
        int compatPadingTop = 0;
        // android 4.4以上将Toolbar添加状态栏高度的上边距，沉浸到状态栏下方
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            compatPadingTop = getStatusBarHeight();
        }
        
        return compatPadingTop;
        
    }*/
    
    private int getStatusBarHeight() {
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
    
}
