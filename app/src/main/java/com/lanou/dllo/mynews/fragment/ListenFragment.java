package com.lanou.dllo.mynews.fragment;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.ListenPagerAdapter;
import com.lanou.dllo.mynews.base.BaseFragment;
import com.lanou.dllo.mynews.bean.ListenBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/3/2.
 */
public class ListenFragment extends BaseFragment implements NetListener {

    private ListView listView;
    private ListenPagerAdapter listenPagerAdapter;
    private List<ListenBean> beans = new ArrayList<>();
    private ListenBean bean = new ListenBean();

    @Override
    protected void initData() {
        NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.3g.163.com/nc/video/home/0-10.html", null, this, ListenBean.class);

    }

    @Override
    protected void initView() {
        listView = bindView(R.id.listen_listview);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_listen;
    }

    @Override
    public void getSuccess(Object o) {
        bean = (ListenBean) o;
        listenPagerAdapter = new ListenPagerAdapter(bean.getVideoList(), getActivity());
        listView.setAdapter(listenPagerAdapter);
    }

    @Override
    public void getFailed(String s) {
    }

    @Override
    public void getSuccessed(ArrayList t) {
    }

}
