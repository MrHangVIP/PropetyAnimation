package com.szh.propetyanimation;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ( (MyAnimView) findViewById(R.id.animView)).vAnimation();
            }
        });
        //3.0以后才能使用 直接实现属性动画效果
        if (Build.VERSION.SDK_INT>=15){
            findViewById(R.id.button).animate().x(500).y(500)
                    .setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {

                        }
                    })
//                    .withStartAction()
                    .alpha(0.5f)
                    .scaleX(2.0f)
                    .setDuration(2500)
                    .setInterpolator(new BounceInterpolator())
                    .start();//start可以不写隐式调用
        }



    }
}
