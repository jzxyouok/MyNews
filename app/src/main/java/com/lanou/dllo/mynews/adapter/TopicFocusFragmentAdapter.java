package com.lanou.dllo.mynews.adapter;

import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.greendao.Focus;
import java.util.List;

/**
 * Created by dllo on 16/3/19.
 */
public class TopicFocusFragmentAdapter extends BaseAdapter {
    private List<Focus> data;

    public void addData(List<Focus> data){
        this.data = data;
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return data!=null&&data.size()>0?data.size():0;
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
        MyFocusViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_focus,null);
            holder = new MyFocusViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.topic_focus_item_title);
            holder.name = (TextView) convertView.findViewById(R.id.topic_focus_item_name);
            holder.alias = (TextView) convertView.findViewById(R.id.topic_focus_item_alias);
            holder.headPicurl = (SimpleDraweeView) convertView.findViewById(R.id.topic_focus_item_headpicurl);
            holder.picurl = (SimpleDraweeView) convertView.findViewById(R.id.topic_focus_item_picurl);
            convertView.setTag(holder);
        } else {
            holder = (MyFocusViewHolder) convertView.getTag();
        }

        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance
                (Resources.getSystem()).setRoundingParams(RoundingParams.asCircle()).build();
        holder.headPicurl.setHierarchy(hierarchy);
        holder.name.setText(data.get(position).getName());
        holder.alias.setText(data.get(position).getAlias());
        holder.title.setText(data.get(position).getTitle());
        holder.headPicurl.setImageURI(Uri.parse(data.get(position).getHeadpicurl()));
        holder.picurl.setImageURI(Uri.parse(data.get(position).getPicurl()));
        return convertView;
    }

    public class MyFocusViewHolder{
        private SimpleDraweeView headPicurl,picurl;
        private TextView title,name,alias;
    }
}
