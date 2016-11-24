package com.szh.propetyanimation;

import android.animation.TimeInterpolator;

/**
 * Created by moram on 2016/11/24.
 */
public class MyInterpolator implements TimeInterpolator{

    /**
     * An interpolator where the rate of change starts and ends slowly but
     * accelerates through the middle.
     */
//    AccelerateDecelerateInterpolator先加速后减速效果 对应源码
//    @HasNativeInterpolator
//    public class AccelerateDecelerateInterpolator extends BaseInterpolator
//            implements NativeInterpolatorFactory {
//        public AccelerateDecelerateInterpolator() {
//        }
//
//        @SuppressWarnings({"UnusedDeclaration"})
//        public AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
//        }
//
//        public float getInterpolation(float input) {
//            return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;（实现加速再减速）
//        }
//
//        /** @hide */
//        @Override
//        public long createNativeInterpolator() {
//            return NativeInterpolatorFactoryHelper.createAccelerateDecelerateInterpolator();
//        }
//    }
    @Override
    public float getInterpolation(float input) {

        //实现自己的过程变化效果、这个值最终会返回给fraction这个变化率
        return input;
    }
}
