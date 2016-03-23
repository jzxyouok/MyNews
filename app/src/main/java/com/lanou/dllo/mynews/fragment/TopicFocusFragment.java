package com.lanou.dllo.mynews.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.TopicContentActivity;
import com.lanou.dllo.mynews.adapter.TopicFocusFragmentAdapter;
import com.lanou.dllo.mynews.base.BaseFragment;
import com.lanou.dllo.mynews.bean.TopicFocusBean;
import com.lanou.dllo.mynews.greendao.DaoMaster;
import com.lanou.dllo.mynews.greendao.DaoSingleton;
import com.lanou.dllo.mynews.greendao.Focus;
import com.lanou.dllo.mynews.greendao.FocusDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/17.
 */
public class TopicFocusFragment extends BaseFragment {
    private ListView listView;
    private List<Focus> beans;
    //private  bean;
    private TopicFocusFragmentAdapter topicFocusFragmentAdapter;
    @Override
    protected void initData() {
        getDBInfo();
        topicFocusFragmentAdapter = new TopicFocusFragmentAdapter();
        topicFocusFragmentAdapter.addData(beans);
        listView.setAdapter(topicFocusFragmentAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TopicContentActivity.class);
                intent.putExtra("expertId", beans.get(position).getExpertId());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                FocusDao focusDao = DaoSingleton.getInstance().getFocusDao();
                Focus focus = focusDao.queryBuilder().list().get(position);
                focusDao.queryBuilder().where(FocusDao.Properties.Name.eq(focus.getName())).buildDelete().executeDeleteWithoutDetachingEntities();
                Toast.makeText(getActivity(), "取消关注", Toast.LENGTH_SHORT).show();
                getDBInfo();
                topicFocusFragmentAdapter = new TopicFocusFragmentAdapter();
                topicFocusFragmentAdapter.addData(beans);
                listView.setAdapter(topicFocusFragmentAdapter);
                return false;
            }
        });


    }

    @Override
    protected void initView() {
        listView = bindView(R.id.topic_focus_listview);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic_focus;
    }

    public void getDBInfo(){

        FocusDao focusDao = DaoSingleton.getInstance().getFocusDao();

        beans = focusDao.queryBuilder().list();


        }
    }

