package com.lanou.dllo.mynews.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.TopicFocusActivity;
import com.lanou.dllo.mynews.adapter.TopicPagerAdapter;
import com.lanou.dllo.mynews.base.BaseFragment;
import com.lanou.dllo.mynews.bean.TopicBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;


/**
 * Created by dllo on 16/3/2.
 */
public class TopicFragment extends BaseFragment implements NetListener {
    private RecyclerView recyclerView;
    private TopicPagerAdapter topicPagerAdapter;
    private ImageView imageView;
    private int requestCode = 1;


    @Override
    protected void initData() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TopicFocusActivity.class);
                startActivityForResult(intent, requestCode);
                getActivity().overridePendingTransition(R.anim.title_before,R.anim.title_after);
            }
        });

//        topicPagerAdapter = new TopicPagerAdapter(getActivity());
//        recyclerView.setAdapter(topicPagerAdapter);
        NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.3g.163.com/newstopic/list/expert/0-10.html", null, this, TopicBean.class);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        topicPagerAdapter.notifyDataSetChanged();

    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.topic_rv);
        imageView = bindView(R.id.topic_title_person);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;
    }


    @Override
    public void getSuccess(Object o) {
        TopicBean bean = (TopicBean) o;
        GridLayoutManager gm = new GridLayoutManager(getActivity(), 1);
        gm.setOrientation(LinearLayoutManager.VERTICAL);
        topicPagerAdapter = new TopicPagerAdapter(getContext(), bean);
        recyclerView.setAdapter(topicPagerAdapter);
//        topicPagerAdapter.addData(bean.getData().getExpertList());
        recyclerView.setLayoutManager(gm);
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList t) {

    }
}
