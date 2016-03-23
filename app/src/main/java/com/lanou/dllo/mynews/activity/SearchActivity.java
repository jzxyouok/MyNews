package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.SearchContentAdapter;
import com.lanou.dllo.mynews.adapter.SearchHotWordAdapter;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.base.BaseApplication;
import com.lanou.dllo.mynews.bean.SearchContentBean;
import com.lanou.dllo.mynews.bean.SearchHotWordBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/20.
 */
public class SearchActivity extends BaseActivity implements NetListener {
    private RecyclerView hotRecyclerView,contentRecyclerView;
    private ImageView back,search,delete;
    private SearchHotWordAdapter searchHotWordAdapter;
    private SearchHotWordBean hotBean;
    private SearchContentBean searchBean;
    private SearchContentAdapter searchContentAdapter;
    private EditText et;
    private String etContent;

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.title_back_before, R.anim.title_back_after);
            }
        });

        final NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.m.163.com/nc/search/hotWord.html",null,this,SearchHotWordBean.class);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotRecyclerView.setVisibility(View.GONE);
                etContent = et.getText().toString();
                if (etContent.length() > 0) {
                    NetHelper helper = new NetHelper();
                    helper.getDataFromNet("http://c.m.163.com/search/comp/MA%3D%3D/20/" + etContent + ".html?deviceId=NjIxRUNGMzItQUUzMi00M0I5LTg3NkYtQkMxOTNDOUQ0REIy&version=NS41LjM%3D&channel=5aS05p2h", null,
                            new NetListener() {
                                @Override
                                public void getSuccess(Object o) {
                                    searchBean = (SearchContentBean) o;
                                    Log.i("1111111", searchBean.toString());
                                    searchContentAdapter = new SearchContentAdapter(searchBean.getDoc().getResult());
                                    contentRecyclerView.setAdapter(searchContentAdapter);
                                    GridLayoutManager gm = new GridLayoutManager(BaseApplication.getContext(), 1);
                                    gm.setOrientation(LinearLayoutManager.VERTICAL);
                                    //searchHotWordAdapter.addData(bean.getData().getExpertList());
                                    contentRecyclerView.setLayoutManager(gm);

                                }

                                @Override
                                public void getFailed(String s) {
                                    Log.i("*********", "失败了");
                                }

                                @Override
                                public void getSuccessed(ArrayList t) {
                                    Log.i("*********", "在这里");
                                }
                            }
                            , SearchContentBean.class);
                }
            }
        });



        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText() != null){
                    et.setText("");
                }
            }
        });
    }

    @Override
    protected void initView() {
        hotRecyclerView = bindView(R.id.search_rv);
        contentRecyclerView = bindView(R.id.search_content_rv);
        back = bindView(R.id.search_back);
        et = bindView(R.id.search_et);
        search = bindView(R.id.search_search);
        delete = bindView(R.id.search_delete);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void getSuccess(Object o) {
        hotBean = (SearchHotWordBean) o;
        searchHotWordAdapter = new SearchHotWordAdapter(hotBean.getHotWordList());
        hotRecyclerView.setAdapter(searchHotWordAdapter);
        GridLayoutManager gm = new GridLayoutManager(this, 2);
        gm.setOrientation(LinearLayoutManager.VERTICAL);
        hotRecyclerView.setLayoutManager(gm);
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(String hot){
        et.setText(hot);
        if (et.getText().length() > 0) {
            delete.setVisibility(View.VISIBLE);
        } else {
            delete.setVisibility(View.GONE);
        }
    }
}
