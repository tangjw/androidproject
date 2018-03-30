package zonsim.tangjunwei.android.nestedscroll;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/28.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class PaddingStatusBarHeightLinearLayout extends LinearLayout {
    public PaddingStatusBarHeightLinearLayout(Context context) {
        super(context);
        setPaddingTop();
    }
    
    public PaddingStatusBarHeightLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPaddingTop();
    }
    
    public PaddingStatusBarHeightLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setPaddingTop();
    }
    
    private void setPaddingTop() {
        int compatPadingTop = 0;
        // android 4.4以上将Toolbar添加状态栏高度的上边距，沉浸到状态栏下方
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            compatPadingTop = getStatusBarHeight();
        }
       setPadding(getPaddingLeft(), getPaddingTop() + compatPadingTop, getPaddingRight(), getPaddingBottom());
    }
    
    private int getStatusBarHeight() {
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
    
}
