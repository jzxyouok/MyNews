package com.lanou.dllo.mynews.fragment;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.Hours24Activity;
import com.lanou.dllo.mynews.activity.SearchActivity;
import com.lanou.dllo.mynews.activity.WeatherActivity;
import com.lanou.dllo.mynews.adapter.NewsPagerAdapter;
import com.lanou.dllo.mynews.base.BaseFragment;
import com.lanou.dllo.mynews.bean.NewsBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 * 新闻页
 */
public class NewsFragment extends BaseFragment implements NetListener {
    private TabLayout tb;
    private ViewPager vp;
    private ArrayList<Fragment> data;
    private NewsPagerAdapter tabLayoutAdapter;
    private ImageView hours, weather,search;


    @Override
    protected void initData() {
        tb = bindView(R.id.news_tb);
        vp = bindView(R.id.news_vp);
        tb.setTabMode(TabLayout.MODE_SCROLLABLE);

        NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.m.163.com/nc/topicset/android/subscribe/manage/listspecial.html", null, this, NewsBean.class);

        hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Hours24Activity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.title_before, R.anim.title_after);
            }
        });
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WeatherActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.title_before, R.anim.title_after);

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.title_before, R.anim.title_after);
            }
        });



    }

    @Override
    protected void initView() {
        hours = bindView(R.id.news_title_hours);
        weather = bindView(R.id.news_title_weather);
        search = bindView(R.id.news_title_search);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void getSuccess(Object o) {
        NewsBean bean = (NewsBean) o;
        data = new ArrayList<>();
        for (int i = 0; i < bean.getTList().size(); i++) {
            data.add(new NewsReuseFragment(bean.getTList().get(i).getTid()));
        }
        tabLayoutAdapter = new NewsPagerAdapter(getActivity().getSupportFragmentManager(), data, getContext());
        vp.setAdapter(tabLayoutAdapter);
        tb.setupWithViewPager(vp);
        for (int i = 0; i < tb.getTabCount(); i++) {
            TabLayout.Tab tab = tb.getTabAt(i);
            if (tab != null) {
                tab.setText(bean.getTList().get(i).getTname());
            }
        }
        vp.setCurrentItem(1);
        vp.setCurrentItem(0);
    }

    @Override
    public void getFailed(String s) {
    }

    @Override
    public void getSuccessed(ArrayList t) {
    }
}
