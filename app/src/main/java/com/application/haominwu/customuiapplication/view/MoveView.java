package com.application.haominwu.customuiapplication.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class MoveView extends android.support.v7.widget.AppCompatTextView {

    private double initRawX;
    private double initRawY;

    public MoveView(Context context) {
        super(context);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initRawX = event.getRawX();
                initRawY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveViewByLayout(event.getRawX(), event.getRawY());
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    private void moveViewByLayout(double rawX, double rawY) {
        int dx = (int)(rawX - initRawX);
        int dy = (int)(rawY - initRawY);
        int left = getLeft() + dx;
        int top = getTop() + dy;
        int right = left + getWidth();
        int bottom = top + getHeight();
        layout(left, top, right, bottom);
        initRawX = rawX;
        initRawY = rawY;
    }

}
