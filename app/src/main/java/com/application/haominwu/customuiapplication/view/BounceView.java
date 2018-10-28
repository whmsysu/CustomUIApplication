package com.application.haominwu.customuiapplication.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;


public class BounceView extends android.support.v7.widget.AppCompatTextView {

    private boolean isMoving = false;

    public BounceView(Context context) {
        super(context);
        init();
    }

    public BounceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BounceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isMoving) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setDuration(3000);
                    valueAnimator.setObjectValues(new PointF(300, 700));
                    valueAnimator.setInterpolator(new DecelerateInterpolator());
                    valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {

                        @Override
                        public PointF evaluate(float fraction, PointF startValue,
                                               PointF endValue) {
                            //贝塞尔曲线
                            PointF point = new PointF();
                            point.x = (1 - fraction) * (1 - fraction) * 0 + 2 * fraction * (1 - fraction) * 250 + fraction * fraction * 500;
                            point.y = (1 - fraction) * (1 - fraction) * 900 + 2 * fraction * (1 - fraction) * (-800) + fraction * fraction * 900;
                            return point;
                        }
                    });


                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            PointF point = (PointF) animation.getAnimatedValue();
                            setX(point.x);
                            setY(point.y);
                        }
                    });

                    valueAnimator.start();


                    isMoving = true;
                }
            }
        });
    }

}