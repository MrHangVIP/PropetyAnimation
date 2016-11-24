package com.szh.propetyanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by moram on 2016/11/24.
 */
public class MyAnimView extends View {
    private static final float RADIUS=50f;

    private Point currentPoint;

    private Paint mPaint;


    private String color;

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
        mPaint.setColor(Color.parseColor(this.color));
        invalidate();
    }

    public MyAnimView(Context context) {
        super(context);
        init();
    }

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(currentPoint ==null){
            currentPoint=new Point(RADIUS,RADIUS);
            drawCircle(canvas);
        }else{
            drawCircle(canvas);
        }

    }

    private void init(){
        mPaint=new Paint();
        mPaint.setColor(Color.GREEN);
    }


    private void drawCircle(Canvas canvas){
        canvas.drawCircle(currentPoint.getX(),currentPoint.getY(),RADIUS,mPaint);
    }

    public void startAnimation(){
        Point startPoint=new Point(RADIUS,RADIUS);
        Point endPoint=new Point(getWidth()-RADIUS,getHeight()-RADIUS);
        ValueAnimator animator=ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint=(Point)animation.getAnimatedValue();
                invalidate();
            }
        });

        ObjectAnimator colorAnimator=ObjectAnimator.ofObject(this,"color",new ColorEvaluator(),
                "#0000FF","#FF0000");

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(animator).with(colorAnimator);
        animatorSet.setInterpolator(new MyInterpolator());
        animatorSet.setDuration(5000);
        animatorSet.start();
    }

    public void vAnimation(){
        Point startPoint=new Point(getWidth()/2,RADIUS);
        Point endPoint=new Point(getWidth()/2,getHeight()-RADIUS);
        ValueAnimator animator=ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint=(Point)animation.getAnimatedValue();
                invalidate();
            }
        });
        ObjectAnimator colorAnimator=ObjectAnimator.ofObject(this,"color",new ColorEvaluator(),
                "#0000FF","#FF0000");

        AnimatorSet animatorSet=new AnimatorSet();
//        animatorSet.setInterpolator(new AccelerateInterpolator(2f));
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.play(animator).with(colorAnimator);
        animatorSet.setDuration(1500);
        animatorSet.start();




    }
}
