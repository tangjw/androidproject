package zonsim.tangjunwei.android.nestedscroll.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import zonsim.tangjunwei.android.nestedscroll.viewoffset.ViewOffsetBehavior;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/29.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class MyBehavior extends ViewOffsetBehavior<NestedScrollView> {
    
    private int height;
    
    public MyBehavior() {
    }
    
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, NestedScrollView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }
    
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, NestedScrollView child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }
    
    @Override
    protected void layoutChild(CoordinatorLayout parent, NestedScrollView child, int layoutDirection) {
        super.layoutChild(parent, child, layoutDirection);
        
        if (height == 0) {
            List<View> dependencies = parent.getDependencies(child);
            
            for (int i = 0; i < dependencies.size(); i++) {
                View view = dependencies.get(i);
                if (view instanceof AppBarLayout) {
                    height = view.getMeasuredHeight();
                    System.out.println("height: " + height);
                }
            }
        }
        
        child.setTop(height);
        child.setBottom(child.getBottom() + height);
        
    }
}
