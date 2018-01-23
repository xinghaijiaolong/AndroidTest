package com.example.test.androidtest;

import android.app.Activity;
import android.os.Bundle;

import android.view.Window;

import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collection;


public class MainActivity extends Activity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);
        TextView textView = findViewById(R.id.tv);
        textView.setText(stringFromJNI());
        ImageView iv = findViewById(R.id.iv);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515994868193&di=1986a3589fa1526c443f91ae9850e14b&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F16%2F41%2F06G58PICfVz_1024.jpg";
        Glide.with(this).load(url).into(iv);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
