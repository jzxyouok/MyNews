package com.lanou.dllo.mynews.activity;

/**
 * Created by dllo on 16/3/2.
 */

import android.content.Intent;
import android.content.SharedPreferences;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.base.BaseActivity;

import cn.jpush.android.api.JPushInterface;


public class WelcomeActivity extends BaseActivity {
    //用来记录是否市第一次启动的文件
    private SharedPreferences sp;
    private boolean isLife = true;


    @Override
    public void initData() {
        //初始化
        sp = getSharedPreferences("welcome", MODE_PRIVATE);
        if (sp.getBoolean("isFirst", true)) {
            //第一次启动
            //1、开启线程，进行倒计时，倒计时结束时跳转
            //2、向sp记录，将isFirst值 记录为false
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isFirst", false);
            editor.commit();

            new Thread(new Runnable() {
                public void run() {

                    try {
                        // 睡眠两秒钟
                        Thread.sleep(2000);
                        Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
                        // 关闭当前页面
                        finish();
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            new Thread(new Runnable() {
                public void run() {

                    try {
                        // 睡眠两秒钟
                        Thread.sleep(2000);
                        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                        // 关闭当前页面
                        finish();
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override
    public void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void onDestroy() {
        isLife = false;
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        JPushInterface.onPause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        JPushInterface.onResume(this);
        super.onResume();
    }
}
