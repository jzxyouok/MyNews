package com.lanou.dllo.mynews.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by dllo on 16/3/5.
 */
public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //解析图片的
        Fresco.initialize(context);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    public static Context getContext() {
        return context;
    }
}
