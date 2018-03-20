package zonsim.tangjunwei.wight;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/20.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class ClockLoadingIndicatorView extends Indicator {
    
    
    private float mAngleValue = 0;
    private float mHourAngleValue = (float) -Math.PI / 2;
    
    @Override
    public void draw(Canvas canvas, Paint paint) {
        
        int width = getWidth();
        int height = getHeight();
        
        float radius = 2 * width / 5;
        float centerX = width / 2;
        float centerY = height / 2;
        
        paint.setStrokeWidth(width / 20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        
        canvas.drawCircle(centerX, centerY, radius, paint);
        
        canvas.drawLine(centerX, centerY, getMinX(centerX, radius), getMinY(centerY, radius), paint);
        canvas.drawLine(centerX, centerY, getHourX(centerX, radius), getHourY(centerY, radius), paint);
        
    }
    
    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        // ofFloat 1000毫秒大概出 60个插值 每次 π/30，校正 回归原点的停顿
        ValueAnimator animator = ValueAnimator.ofFloat(0, (float) (2 * Math.PI));
        animator.setDuration(800);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        addUpdateListener(animator, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float temp = (float) animation.getAnimatedValue();
                if (temp > mAngleValue) {
                    mHourAngleValue += (temp - mAngleValue) / 12;
                } else if (temp < mAngleValue) {
                    mHourAngleValue += (temp + 2 * Math.PI - mAngleValue) / 12;
                }
                if (mHourAngleValue > 2 * Math.PI) {
                    mHourAngleValue -= 2 * Math.PI;
                    System.out.println(mHourAngleValue + "===============");
                }
                    
                mAngleValue = temp;
                
                postInvalidate();
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animators.add(animator);
        return animators;
    }
    
    private float getMinY(float centerY, float radius) {
        
        //分针长度
        float length = 7 * radius / 10;
        
        double cos = Math.cos(mAngleValue) * length;
        
        return (float) (centerY - cos);
    }
    
    private float getMinX(float centerX, float radius) {
        //分针长度
        float length = 7 * radius / 10;
        
        double sin = Math.sin(mAngleValue) * length;
        
        return (float) (centerX + sin);
    }
    
    private float getHourX(float centerX, float radius) {
        //时针长度
        float length = radius / 2;
        
        double sin = Math.sin(mHourAngleValue) * length;
        
        return (float) (centerX + sin);
    }
    
    private float getHourY(float centerY, float radius) {
        //时针长度
        float length = radius / 2;
        
        double cos = Math.cos(mHourAngleValue) * length;
        
        return (float) (centerY - cos);
    }
    
}
