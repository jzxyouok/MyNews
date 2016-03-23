package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.TopicFocusAdapter;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.base.BaseApplication;
import com.lanou.dllo.mynews.fragment.TopicFocusFragment;
import com.lanou.dllo.mynews.fragment.TopicFragment;
import com.lanou.dllo.mynews.fragment.TopicReleaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/17.
 */
public class TopicFocusActivity extends BaseActivity {
    private ImageView back;
    private TabLayout tb;
    private ViewPager vp;
    private ArrayList<Fragment> data;
    private TopicFocusAdapter topicFocusAdapter;

    @Override
    protected void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TopicFocusActivity.this, TopicFragment.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.title_back_before,R.anim.title_back_after);
                finish();
            }
        });
        data = new ArrayList<>();
        data.add(new TopicFocusFragment());
        data.add(new TopicReleaseFragment());
        topicFocusAdapter = new TopicFocusAdapter(getSupportFragmentManager(), data, BaseApplication.getContext());
        vp.setAdapter(topicFocusAdapter);
        tb.setupWithViewPager(vp);
        for (int i = 0; i < tb.getTabCount(); i++) {
            TabLayout.Tab tab = tb.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(topicFocusAdapter.getTabView(i));
            }
        }
        vp.setCurrentItem(1);
        vp.setCurrentItem(0);
    }

    @Override
    protected void initView() {
        back = bindView(R.id.focus_back);
        tb = bindView(R.id.topic_focus_tb);
        vp = bindView(R.id.topic_focus_vp);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_topic_focus;
    }
}
