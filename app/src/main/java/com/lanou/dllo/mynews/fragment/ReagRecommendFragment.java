package com.lanou.dllo.mynews.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.ReadRecommendContentActivity;
import com.lanou.dllo.mynews.adapter.ReadRecommendAdapter;
import com.lanou.dllo.mynews.base.BaseFragment;
import com.lanou.dllo.mynews.bean.ReadRecommendBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/7.
 */
public class ReagRecommendFragment extends BaseFragment implements NetListener {
    private ListView listView;
    private ReadRecommendAdapter readRecommendAdapter;
    private boolean isBottom = false;
    private int itemId = 0;
    private Context context;
    private ReadRecommendBean recomBean = new ReadRecommendBean();
    private List<ReadRecommendBean.RecomEntity> beans = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void initData() {
        NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.3g.163.com/recommend/getSubDocPic?from=yuedu&size=20&passport=&devId=Q610VDHKykNsSyIsZeQSvA%3D%3D&lat=2iyUFnr1jNi0SDNFC6stig%3D%3D&lon=41681P%2BIcCskHnLcwx4Izw%3D%3D&version=5.4.9&net=wifi&ts=1457182824&sign=hfyMazvPQQ%2BHkQ3SUobYi7MlcrKR6tP1mD%2Btpktd9Qt48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=miliao_news",
                null, this, ReadRecommendBean.class);


        listView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (listView.getLastVisiblePosition() == beans.size() - 1 && isBottom) {
                    NetHelper helper = new NetHelper();
                    helper.getDataFromNet("http://c.3g.163.com/recommend/getSubDocPic?from=yuedu&size=20&passport=&devId=Q610VDHKykNsSyIsZeQSvA%3D%3D&lat=2iyUFnr1jNi0SDNFC6stig%3D%3D&lon=41681P%2BIcCskHnLcwx4Izw%3D%3D&version=5.4.9&net=wifi&ts=1457182824&sign=hfyMazvPQQ%2BHkQ3SUobYi7MlcrKR6tP1mD%2Btpktd9Qt48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=miliao_news",
                            null, new NetListener() {
                                @Override
                                public void getSuccess(Object o) {
                                    Toast.makeText(getActivity(), "加载成功", Toast.LENGTH_SHORT).show();
                                    ReadRecommendBean b = (ReadRecommendBean) o;
                                    readRecommendAdapter.addData(b.getRecom());//适配器中 定义一个方法 往里面加入list集合
                                    listView.setSelection(itemId - 1);
                                }

                                @Override
                                public void getFailed(String s) {
                                }

                                @Override
                                public void getSuccessed(ArrayList t) {
                                }
                            }, ReadRecommendBean.class);

                    isBottom = false;
                } else if (listView.getLastVisiblePosition() != beans.size() - 1) {
                    isBottom = true;
                }
            }
        });
        reFresh();
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.reading_recom_lv);
        swipeRefreshLayout = bindView(R.id.reading_recom_refresh);
    }

    private void reFresh() {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        NetHelper helper = new NetHelper();
                        helper.getDataFromNet("http://c.3g.163.com/recommend/getSubDocPic?from=yuedu&size=20&passport=&devId=Q610VDHKykNsSyIsZeQSvA%3D%3D&lat=2iyUFnr1jNi0SDNFC6stig%3D%3D&lon=41681P%2BIcCskHnLcwx4Izw%3D%3D&version=5.4.9&net=wifi&ts=1457182824&sign=hfyMazvPQQ%2BHkQ3SUobYi7MlcrKR6tP1mD%2Btpktd9Qt48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=miliao_news",
                                null, new NetListener() {
                                    @Override
                                    public void getSuccess(Object o) {
                                        ReadRecommendBean b = (ReadRecommendBean) o;
                                        readRecommendAdapter.addNewData(b.getRecom());//适配器中 定义一个方法 往里面加入list集合
                                    }

                                    @Override
                                    public void getFailed(String s) {
                                    }

                                    @Override
                                    public void getSuccessed(ArrayList t) {
                                    }
                                }, ReadRecommendBean.class);

                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_read_recommend;
    }

    @Override
    public void getSuccess(Object o) {
        recomBean = (ReadRecommendBean) o;
        beans = recomBean.getRecom();
        readRecommendAdapter = new ReadRecommendAdapter(recomBean.getRecom());
        listView.setAdapter(readRecommendAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ReadRecommendContentActivity.class);
                intent.putExtra("myId", recomBean.getRecom().get(position).getId());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.content_before,R.anim.content_after);
            }
        });
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList t) {

    }
}
