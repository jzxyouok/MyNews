package com.lanou.dllo.mynews.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.base.BaseActivity;

/**
 * Created by dllo on 16/3/9.
 */
public class GoldMallActivity extends BaseActivity {
    private WebView webView;

    @Override
    protected void initData() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.taobao.com/");
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.mall_webview);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_golemall;
    }
}
