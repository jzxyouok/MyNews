package com.lanou.dllo.mynews.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lanou.dllo.mynews.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/7.
 */
public class ReadPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    private Context context;
    private String[] titles = {"推荐", "订阅"};

    public ReadPagerAdapter(FragmentManager fm, ArrayList<Fragment> data, Context context) {
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

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_read_tablayout, null);
        TextView tv = (TextView) view.findViewById(R.id.read_tab_tv);
        tv.setText(titles[position]);
        return view;
    }
}
