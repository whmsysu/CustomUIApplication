package com.application.haominwu.customuiapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.application.haominwu.customuiapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.btn_move_view)
    public void gotoMoveViewPlayground() {
        Intent intent = new Intent();
        intent.setClass(this, TouchMovingActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_bounce_view)
    public void gotoBounceViewPlayground() {
        Intent intent = new Intent();
        intent.setClass(this, BounceViewActivity.class);
        startActivity(intent);
    }

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Example of a call to a native method
//        TextView tv = findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
