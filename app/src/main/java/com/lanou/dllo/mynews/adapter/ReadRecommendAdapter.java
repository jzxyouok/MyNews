package com.lanou.dllo.mynews.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.ReadRecommendBean;

import java.util.List;

/**
 * Created by dllo on 16/3/8.
 */
public class ReadRecommendAdapter extends BaseAdapter {
    private List<ReadRecommendBean.RecomEntity> data;

    public ReadRecommendAdapter(List<ReadRecommendBean.RecomEntity> data) {

        this.data = data;
    }

    public void addData(List<ReadRecommendBean.RecomEntity> datas) {
        data.addAll(datas);
        notifyDataSetChanged();
    }

    public void addNewData(List<ReadRecommendBean.RecomEntity> datas) {
        data.clear();
        data.addAll(datas);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_read_recom, null);
            holder = new MyViewHolder();
            holder.imgsrc = (SimpleDraweeView) convertView.findViewById(R.id.read_recom_item_imgsrc);
            holder.title_tv = (TextView) convertView.findViewById(R.id.read_recom_item_title);
            holder.pTime_tv = (TextView) convertView.findViewById(R.id.read_recom_item_ptime);
            holder.source_tv = (TextView) convertView.findViewById(R.id.read_recom_item_source);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        if (data.get(position).getImgsrc() != null) {
            holder.imgsrc.setImageURI(Uri.parse(data.get(position).getImgsrc()));
        } else {
            holder.imgsrc.setImageURI(null);
        }
        holder.title_tv.setText(data.get(position).getTitle());
        holder.pTime_tv.setText(data.get(position).getPtime());
        holder.source_tv.setText(data.get(position).getSource());
        return convertView;
    }

    public class MyViewHolder {
        SimpleDraweeView imgsrc;
        TextView title_tv, pTime_tv, source_tv;
    }
}
