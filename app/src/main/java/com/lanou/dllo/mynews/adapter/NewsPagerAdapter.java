package com.lanou.dllo.mynews.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/3.
 */
public class NewsPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    private Context context;
    private String[] titles = {"头条", "体育", "大连", "天气"};


    public NewsPagerAdapter(FragmentManager fm, ArrayList<Fragment> data, Context context) {
        super(fm);
        this.data = data;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

}
