package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.bean.ReadRecommendContentBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by dllo on 16/3/18.
 */
public class ReadRecommendContentActivity extends BaseActivity implements NetListener<JSONObject> {

    private String myId;
    private ReadRecommendContentBean bean;
    private ImageView back;
    private TextView title,source,sourceName,body,pTime;
    private SimpleDraweeView src;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        myId = intent.getStringExtra("myId");
        NetHelper netHelper = new NetHelper();
        netHelper.getNewsContentFromNet("http://c.m.163.com/nc/article/" + myId + "/full.html", this);
        //netHelper.getDataFromNet("http://c.3g.163.com/nc/article/BICBNB6N05178VBM/full.html",null,this, ReadRecommendContentBean.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @Override
    protected void initView() {
        back = bindView(R.id.read_recom_content_back);
        body = bindView(R.id.read_recom_content_body);
        title = bindView(R.id.read_recom_content_title);
        source = bindView(R.id.read_recom_content_source);
        sourceName = bindView(R.id.read_recom_content_source_name);
        pTime = bindView(R.id.read_recom_content_ptime);
        src = bindView(R.id.read_recom_content_src);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_read_recommend_content;
    }

    @Override
    public void getSuccess(JSONObject jsonObject) {
        JSONObject object = jsonObject;
        try {
            JSONObject data = object.getJSONObject(myId);
            Gson gson = new Gson();
            bean = gson.fromJson(data.toString(),ReadRecommendContentBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        body.setText(Html.fromHtml(bean.getBody()));
        title.setText(bean.getTitle());
        src.setImageURI(Uri.parse(bean.getImg().get(0).getSrc()));
        source.setText(bean.getSource());
        sourceName.setText(bean.getSource());
        pTime.setText(bean.getPtime());
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList t) {

    }
}
