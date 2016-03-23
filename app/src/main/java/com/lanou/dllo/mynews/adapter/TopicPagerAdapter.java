package com.lanou.dllo.mynews.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.TopicContentActivity;
import com.lanou.dllo.mynews.bean.TopicBean;
import com.lanou.dllo.mynews.greendao.DaoSingleton;
import com.lanou.dllo.mynews.greendao.Focus;
import com.lanou.dllo.mynews.greendao.FocusDao;

import java.util.List;

/**
 * Created by dllo on 16/3/4.
 */
public class TopicPagerAdapter extends RecyclerView.Adapter<TopicPagerAdapter.MyViewHolder> {
    //    private List<TopicBean.DataEntity.ExpertListEntity> data;
    private Context context;
    //    private TopicBean.DataEntity.ExpertListEntity bean;
    private TopicBean topicBean;

    public TopicPagerAdapter(Context context, TopicBean topicBean) {
        this.context = context;
        this.topicBean = topicBean;
    }

//    public TopicPagerAdapter(Context context) {
//        this.context = context;
//    }
//
//    public void addData(List<TopicBean.DataEntity.ExpertListEntity> data) {
//        this.data = data;
//        notifyDataSetChanged();
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
//        bean = data.get(position);
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance
                (Resources.getSystem()).setRoundingParams(RoundingParams.asCircle()).build();
        //设置圆形圆角参数；RoundingParams.asCircle()是将图像设置成圆形
        holder.headpicurl.setHierarchy(hierarchy);
        holder.picurl.setImageURI(Uri.parse(topicBean.getData().getExpertList().get(position).getPicurl()));
        holder.headpicurl.setImageURI(Uri.parse(topicBean.getData().getExpertList().get(position).getHeadpicurl()));
        holder.alias.setText(topicBean.getData().getExpertList().get(position).getAlias());
        holder.concernCount.setText(String.valueOf(topicBean.getData().getExpertList().get(position).getConcernCount()) + "关注");
        holder.title.setText(topicBean.getData().getExpertList().get(position).getTitle());
        holder.questionCount.setText(String.valueOf(topicBean.getData().getExpertList().get(position).getQuestionCount()) + "提问");
        holder.answerCount.setText(String.valueOf(topicBean.getData().getExpertList().get(position).getAnswerCount()) + "已回答");
        holder.classification.setText(topicBean.getData().getExpertList().get(position ).getClassification());
        holder.name.setText(topicBean.getData().getExpertList().get(position).getName());
        holder.expertId = topicBean.getData().getExpertList().get(position).getExpertId();
        FocusDao focusDao = DaoSingleton.getInstance().getFocusDao();
        Focus data = new Focus();
        data.setName(topicBean.getData().getExpertList().get(position).getName());
        data.setAlias(topicBean.getData().getExpertList().get(position).getAlias());
        data.setClassification(topicBean.getData().getExpertList().get(position).getClassification());
        data.setTitle(topicBean.getData().getExpertList().get(position).getTitle());
        data.setPicurl(topicBean.getData().getExpertList().get(position).getPicurl());
        data.setHeadpicurl(topicBean.getData().getExpertList().get(position).getHeadpicurl());
        data.setExpertId(topicBean.getData().getExpertList().get(position).getExpertId());
        List<Focus> list = focusDao.queryBuilder().where(FocusDao.Properties.Name.eq(data.getName())).list();
        if (list.size() == 0) {
            holder.focus.setText("+ 关注");
        } else {
            holder.focus.setText("取消关注");
        }
        holder.focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FocusDao focusDao = DaoSingleton.getInstance().getFocusDao();
                Focus data = new Focus();
                data.setName(topicBean.getData().getExpertList().get(position).getName());
                data.setAlias(topicBean.getData().getExpertList().get(position).getAlias());
                data.setClassification(topicBean.getData().getExpertList().get(position).getClassification());
                data.setTitle(topicBean.getData().getExpertList().get(position).getTitle());
                data.setPicurl(topicBean.getData().getExpertList().get(position).getPicurl());
                data.setHeadpicurl(topicBean.getData().getExpertList().get(position).getHeadpicurl());
                data.setExpertId(topicBean.getData().getExpertList().get(position).getExpertId());
                List<Focus> list = focusDao.queryBuilder().where(FocusDao.Properties.Name.eq(data.getName())).list();
                if (list.size() == 0) {
                    focusDao.insert(data);
                    Toast.makeText(context, "关注成功", Toast.LENGTH_SHORT).show();
                    holder.focus.setText("取消关注");
                } else {
                    focusDao.queryBuilder().where(FocusDao.Properties.Name.eq(data.getName())).buildDelete().executeDeleteWithoutDetachingEntities();
                    holder.focus.setText("+ 关注");
                    Toast.makeText(context, "取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    @Override
//    public int getItemCount() {
//        return data != null && data.size() > 0 ? data.size() : 0;
//    }

    @Override
    public int getItemCount() {
        return topicBean.getData().getExpertList() != null && topicBean.getData().getExpertList().size() > 0 ? topicBean.getData().getExpertList().size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView alias;//背景图下面的字
        private SimpleDraweeView picurl;//背景图
        private SimpleDraweeView headpicurl;//头像
        private TextView concernCount;//多少人关注
        private TextView title;//职业
        private TextView questionCount;//问题数
        private TextView answerCount;//回答数
        private TextView name;//名字
        private TextView classification;//健康
        private String expertId;
        private TextView focus;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TopicContentActivity.class);
                    intent.putExtra("expertId", expertId);
                    context.startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.content_before, R.anim.content_after);

                }
            });
            alias = (TextView) itemView.findViewById(R.id.topic_item_alias);
            picurl = (SimpleDraweeView) itemView.findViewById(R.id.topic_item_picurl);
            headpicurl = (SimpleDraweeView) itemView.findViewById(R.id.topic_item_headpicurl);
            concernCount = (TextView) itemView.findViewById(R.id.topic_item_concern);
            title = (TextView) itemView.findViewById(R.id.topic_item_title);
            questionCount = (TextView) itemView.findViewById(R.id.topic_item_question);
            answerCount = (TextView) itemView.findViewById(R.id.topic_item_answer);
            name = (TextView) itemView.findViewById(R.id.topic_item_name);
            classification = (TextView) itemView.findViewById(R.id.topic_item_classification);
            focus = (TextView) itemView.findViewById(R.id.topic_item_focus);

        }
    }
}
