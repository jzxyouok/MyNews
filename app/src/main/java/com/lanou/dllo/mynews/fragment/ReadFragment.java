package com.lanou.dllo.mynews.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.ReadPagerAdapter;
import com.lanou.dllo.mynews.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public class ReadFragment extends BaseFragment {

    private TabLayout tb;
    private ViewPager vp;
    private ArrayList<Fragment> data;
    private ReadPagerAdapter readPagerAdapter;


    @Override
    protected void initData() {

        data = new ArrayList<>();
        data.add(new ReagRecommendFragment());
        data.add(new ReadOrderFragment());
        readPagerAdapter = new ReadPagerAdapter(getActivity().getSupportFragmentManager(), data, getContext());
        vp.setAdapter(readPagerAdapter);
        tb.setupWithViewPager(vp);
        for (int i = 0; i < tb.getTabCount(); i++) {
            TabLayout.Tab tab = tb.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(readPagerAdapter.getTabView(i));
            }
        }
        vp.setCurrentItem(1);
        vp.setCurrentItem(0);
    }

    @Override
    protected void initView() {
        tb = bindView(R.id.reading_tb);
        vp = bindView(R.id.reading_vp);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_read;
    }
}
