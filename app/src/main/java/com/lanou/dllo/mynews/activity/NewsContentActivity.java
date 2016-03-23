package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.NewsContentAdapter;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.bean.MyNewsContentBean;
import com.lanou.dllo.mynews.bean.NewsContentBean;
import com.lanou.dllo.mynews.bean.NewsPageBean;
import com.lanou.dllo.mynews.net.SingleQueue;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/12.
 */
public class NewsContentActivity extends BaseActivity {
    private ListView listView;
    private String id;
    private NewsContentAdapter newsContentAdapter;
    private NewsContentBean bean;
    private ArrayList<MyNewsContentBean> beans;
    private String url;
    private RequestQueue queue;
    private ImageView back;
    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("url");
        url = " http://c.3g.163.com/nc/article/" + id + "/full.html";

        queue = SingleQueue.getInstance().getQueue();
        beans = new ArrayList<>();


        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject o = response.getJSONObject(id);
                    bean = new Gson().fromJson(o.toString(), NewsContentBean.class);
                    String body = bean.getBody();
                    if (body == null) {
                        Toast.makeText(NewsContentActivity.this, "新闻不存在", Toast.LENGTH_SHORT).show();
                        NewsContentActivity.this.finish();
                    }
                    String[] content = body.split("<\\/p>");
                    int j = 0;
                    for (int i = 0; i < content.length; i++) {
                        MyNewsContentBean myBean = new MyNewsContentBean();
                        if (content[i].contains("IMG#")) {
                            myBean.setImgUrl(bean.getImg().get(j).getSrc());
                            j++;
                        }

                        myBean.setContent(content[i]);
                        beans.add(myBean);
                    }
                    newsContentAdapter = new NewsContentAdapter(beans);
//                    listView.addHeaderView(headView);
                    listView.setAdapter(newsContentAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initView() {
        listView = bindView(R.id.news_content_listview);
        back = bindView(R.id.news_content_back);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_news_singlenews;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
