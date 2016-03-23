package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.Hours24PagerAdapter;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.base.NestedListView;
import com.lanou.dllo.mynews.bean.Hours24Bean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dllo on 16/3/14.
 */
public class Hours24Activity extends BaseActivity implements NetListener{
    private Toolbar toolbar;
    private ImageView back;
    private Hours24Bean bean;
    private List<Hours24Bean.T1429173762551Entity> beans;
    private Hours24PagerAdapter hours24PagerAdapter;
    private NestedListView nestedListView;

    @Override
    protected void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hours24Activity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.title_back_before,R.anim.title_back_after);
            }
        });

        NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.3g.163.com/nc/article/list/T1429173762551/0-20.html",null,this, Hours24Bean.class);

    }

    @Override
    protected void initView() {
        toolbar = bindView(R.id.hour24_toolbar);
        back = bindView(R.id.hour24_back);
        nestedListView = bindView(R.id.hour24_listview);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_hours24;
    }

    @Override
    public void getSuccess(Object o) {
        bean = (Hours24Bean) o;
        //beans = (List<Hours24Bean.T1429173762551Entity>) o;
        hours24PagerAdapter = new Hours24PagerAdapter(bean.getT1429173762551());
        nestedListView.setAdapter(hours24PagerAdapter);
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList t) {

    }
}
