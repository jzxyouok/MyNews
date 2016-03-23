package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.base.BaseActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;

/**
 * Created by dllo on 16/3/9.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView login_qq, login_sina;
    private static final int REGISTER = 10;

    @Override
    protected void initData() {
        login_qq.setOnClickListener(this);
        login_sina.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        login_qq = bindView(R.id.login_qq);
        login_sina = bindView(R.id.login_sina);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_qq:
                ShareSDK.initSDK(this);
                getQQLogin();
                break;
            case R.id.login_sina:
                ShareSDK.initSDK(this);
                getSinaWeiboLogin();
                break;
        }
    }

    public void getQQLogin() {
        Platform platform = ShareSDK.getPlatform(QZone.NAME);
        if (platform.isAuthValid()) {
            platform.removeAccount();
        }
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.i("android", platform.getDb().getUserName());
                String head = platform.getDb().getUserIcon();//获取的头像是 URL 的头像地址
                String name = platform.getDb().getUserName();
                // 把第三方登录的用户名和头像 String 类型的 URL 传递回我页面
                //带返回码的跳转传值
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("head", head);
                setResult(REGISTER, intent);
                finish();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });
        platform.SSOSetting(false);
        platform.showUser(null);
    }

    public void getSinaWeiboLogin() {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        if (platform.isAuthValid()) {
            platform.removeAccount();
        }
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.i("android", platform.getDb().getUserName());
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
            }

            @Override
            public void onCancel(Platform platform, int i) {
            }
        });
        platform.SSOSetting(false);
        platform.showUser(null);
    }
}
