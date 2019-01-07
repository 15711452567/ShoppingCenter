package com.example.lenovo.shoppingcenter;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * date:2018.12.28
 * author:赵颖冰(lenovo)
 * function:
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
