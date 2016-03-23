package com.lanou.dllo.mynews.adapter;

import android.content.Context;
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
import com.lanou.dllo.mynews.bean.TopicContentBean;

/**
 * Created by dllo on 16/3/16.
 */
public class TopicContentPagerAdapter extends BaseAdapter {
    private TopicContentBean.DataEntity bean;
    private Context context;

    public TopicContentPagerAdapter(TopicContentBean.DataEntity bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.getLatestList().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getLatestList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyTopicContentHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_content, null);
            holder = new MyTopicContentHolder();
            holder.userHeadPicUrl = (SimpleDraweeView) convertView.findViewById(R.id.item_topic_content_userHeadPicUrl);
            holder.specialistHeadPicUrl = (SimpleDraweeView) convertView.findViewById(R.id.item_topic_content_specialistHeadPicUrl);
            holder.userName = (TextView) convertView.findViewById(R.id.item_topic_content_userName);
            holder.userContent = (TextView) convertView.findViewById(R.id.item_topic_content_content);
            holder.specialistName = (TextView) convertView.findViewById(R.id.item_topic_content_specialistName);
            holder.specialistContent = (TextView) convertView.findViewById(R.id.item_topic_content_spcontent);
            convertView.setTag(holder);
        } else {
            holder = (MyTopicContentHolder) convertView.getTag();
        }
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(Resources.getSystem())
                //设置圆形圆角参数；RoundingParams.asCircle()是将图像设置成圆形
                .setRoundingParams(RoundingParams.asCircle()).build();
        GenericDraweeHierarchy hierarchy1 = GenericDraweeHierarchyBuilder.newInstance(Resources.getSystem())
                //设置圆形圆角参数；RoundingParams.asCircle()是将图像设置成圆形
                .setRoundingParams(RoundingParams.asCircle()).build();
        holder.userHeadPicUrl.setHierarchy(hierarchy);
        holder.specialistHeadPicUrl.setHierarchy(hierarchy1);
        if (bean.getLatestList().get(position).getQuestion().getUserHeadPicUrl() != null) {
            holder.userHeadPicUrl.setImageURI(Uri.parse(bean.getLatestList().get(position).getQuestion().getUserHeadPicUrl()));
        } else {
            holder.userHeadPicUrl.setImageURI(Uri.parse("http://c.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=c4a97118d3160924dc70aa1fe13719cc/f11f3a292df5e0feeb719f4f5f6034a85edf7216.jpg"));
        }
        holder.specialistHeadPicUrl.setImageURI(Uri.parse(bean.getLatestList().get(position).getAnswer().getSpecialistHeadPicUrl()));
        holder.userName.setText(bean.getLatestList().get(position).getQuestion().getUserName());
        holder.userContent.setText(bean.getLatestList().get(position).getQuestion().getContent());
        holder.specialistName.setText(bean.getLatestList().get(position).getAnswer().getSpecialistName());
        holder.specialistContent.setText(bean.getLatestList().get(position).getAnswer().getContent());
        return convertView;
    }

    public class MyTopicContentHolder {
        SimpleDraweeView userHeadPicUrl, specialistHeadPicUrl;
        TextView userName, userContent, specialistName, specialistContent;
    }

}

