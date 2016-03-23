package com.lanou.dllo.mynews.adapter;

import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.MyNewsContentBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/20.
 */
public class NewsContentAdapter extends BaseAdapter{
    private ArrayList<MyNewsContentBean> beans;

    public NewsContentAdapter(ArrayList<MyNewsContentBean> beans) {
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyTopicContentHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_content,null);
            holder = new MyTopicContentHolder();
            holder.newsContent_tv = (TextView) convertView.findViewById(R.id.item_news_content_tv);
            holder.newsContent_sdv = (SimpleDraweeView) convertView.findViewById(R.id.item_news_content_iv);
            convertView.setTag(holder);
        } else {
            holder = (MyTopicContentHolder) convertView.getTag();
        }
        holder.newsContent_tv.setText(Html.fromHtml(beans.get(position).getContent()));
        holder.newsContent_sdv.setVisibility(View.VISIBLE);
        if (beans.get(position).getImgUrl() != null) {
            holder.newsContent_sdv.setImageURI(Uri.parse(beans.get(position).getImgUrl()));
        }else {
            holder.newsContent_sdv.setVisibility(View.GONE);
        }

        return convertView;
    }

    public class MyTopicContentHolder{
        TextView newsContent_tv;
        SimpleDraweeView newsContent_sdv;
    }

}
