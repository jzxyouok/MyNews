package com.lanou.dllo.mynews.net;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/14.
 */
public class TopPullLoading<T> {

    private String url;
    private ListView listView;
    private Class<T> clazz;
    private boolean isBottom = false;
    private ArrayList<T> data;

    public TopPullLoading(String url, ListView listView) {
        this.url = url;
        this.listView = listView;
    }

    public void getDataFromNet(final String url, final ListView listView) {
        listView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (listView.getLastVisiblePosition() == data.size() - 1 && isBottom) {
                    NetHelper netHelper = new NetHelper();
                    netHelper.getDataFromNet(url, null, new NetListener() {
                        @Override
                        public void getSuccess(Object o) {

                        }

                        @Override
                        public void getFailed(String s) {

                        }

                        @Override
                        public void getSuccessed(ArrayList t) {
                            data.addAll(t);
                        }
                    }, clazz);
                    isBottom = false;
                } else if (listView.getLastVisiblePosition() != data.size() - 1) {
                    isBottom = true;
                }
            }
        });
    }
}
