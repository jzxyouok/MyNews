package com.lanou.dllo.mynews.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.Hours24Bean;

import java.util.List;

/**
 * Created by zhang on 2016/3/14.
 */
public class Hours24PagerAdapter extends BaseAdapter {
    private Hours24Bean bean;
    private List<Hours24Bean.T1429173762551Entity> beans;

    public Hours24PagerAdapter(List<Hours24Bean.T1429173762551Entity> beans) {
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
        MyHoursViewHolder holder = null;
        if (convertView == null) {
            //convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hours,parent,false);
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hours, null);
            holder = new MyHoursViewHolder();
            holder.digest = (TextView) convertView.findViewById(R.id.item_hours_digest);
            holder.tTitle = (TextView) convertView.findViewById(R.id.item_hours_title);
            holder.pTime = (TextView) convertView.findViewById(R.id.item_hours_pTime);
            holder.replyCount = (TextView) convertView.findViewById(R.id.item_hours_replycount);
            holder.source = (TextView) convertView.findViewById(R.id.item_hours_source);
            holder.imgsrc = (SimpleDraweeView) convertView.findViewById(R.id.item_hours_iv);
            convertView.setTag(holder);
        } else {
            holder = (MyHoursViewHolder) convertView.getTag();
        }
        holder.tTitle.setText(beans.get(position).getTitle());
        holder.pTime.setText(beans.get(position).getPtime());
        holder.digest.setText(beans.get(position).getDigest());
        holder.replyCount.setText(String.valueOf(beans.get(position).getReplyCount()) + "跟帖");
        holder.source.setText(beans.get(position).getSource());
        holder.imgsrc.setImageURI(Uri.parse(beans.get(position).getImgsrc()));
        return convertView;
    }

    public class MyHoursViewHolder {
        TextView pTime;
        TextView tTitle;
        TextView digest;
        TextView replyCount;
        TextView source;
        SimpleDraweeView imgsrc;
    }
}
