package com.lanou.dllo.mynews.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.NewsPageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/7.
 */
public class NewsReusePagerApapter extends BaseAdapter {
    private List<NewsPageBean> data;
    private LayoutInflater inflater;
    public static final int ONEPICTURE = 0;
    public static final int THREEPICTURE = 1;
    private Context context;

    public NewsReusePagerApapter(List<NewsPageBean> data, Context context) {
        this.data = data;
        this.context = context;


    }

    public void addData(ArrayList<NewsPageBean> datas) {
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
    public int getItemViewType(int position) {
        if (position % 2 == 0)
            return ONEPICTURE;
        else
            return THREEPICTURE;

    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        OnePictureViewHolder onePictureViewHolder = null;
        ThreePictureViewHolder threePictureViewHolder = null;

        int type = getItemViewType(position);
        if (convertView == null) {
            inflater = LayoutInflater.from(parent.getContext());
            // 按当前所需的样式，确定new的布局
            switch (type) {
                case ONEPICTURE:
                    convertView = inflater.inflate(R.layout.item_news_onepicture, parent, false);
                    onePictureViewHolder = new OnePictureViewHolder();
                    onePictureViewHolder.onePictureView = (SimpleDraweeView) convertView.findViewById(R.id.item_news_onepicture_view);
                    onePictureViewHolder.onePictureTitle = (TextView) convertView.findViewById(R.id.item_news_onepicture_title);
                    onePictureViewHolder.onePictureDigest = (TextView) convertView.findViewById(R.id.item_news_onepicture_desight);
                    convertView.setTag(onePictureViewHolder);
                    break;
                case THREEPICTURE:
                    convertView = inflater.inflate(R.layout.item_news_threepicture, parent, false);
                    threePictureViewHolder = new ThreePictureViewHolder();
                    threePictureViewHolder.threePictureBigView = (SimpleDraweeView) convertView.findViewById(R.id.item_news_threepicture_big);
                    threePictureViewHolder.threePictureLittleTop = (SimpleDraweeView) convertView.findViewById(R.id.item_news_threepicture_little_top);
                    threePictureViewHolder.threePictureLittleBotton = (SimpleDraweeView) convertView.findViewById(R.id.item_news_threepicture_little_botton);
                    threePictureViewHolder.threePictureTitle = (TextView) convertView.findViewById(R.id.item_news_threepicture_title);
                    threePictureViewHolder.threePictureDigest = (TextView) convertView.findViewById(R.id.item_news_threepicture_digest);
                    convertView.setTag(threePictureViewHolder);
                    break;
                default:
                    break;


            }


        } else {
            switch (type) {
//
                case ONEPICTURE:
                    onePictureViewHolder = (OnePictureViewHolder) convertView.getTag();
                    break;
                case THREEPICTURE:
                    threePictureViewHolder = (ThreePictureViewHolder) convertView.getTag();
                    break;
            }
        }
        //设置资源
        switch (type) {


            case ONEPICTURE:

                if (data.get(position).getImgsrc() != null) {

                    onePictureViewHolder.onePictureView.setImageURI(Uri.parse(data.get(position).getImgsrc()));
                }
                onePictureViewHolder.onePictureTitle.setText(data.get(position).getTitle());
                onePictureViewHolder.onePictureDigest.setText(data.get(position).getDigest());

                break;
            case THREEPICTURE:

                if (data.get(position).getImgsrc() != null) {

                    threePictureViewHolder.threePictureBigView.setImageURI(Uri.parse(data.get(position).getImgsrc()));
                }
                threePictureViewHolder.threePictureLittleTop.setImageURI(Uri.parse(data.get(position).getImgsrc()));
                threePictureViewHolder.threePictureLittleBotton.setImageURI(Uri.parse(data.get(position).getImgsrc()));
                threePictureViewHolder.threePictureTitle.setText(data.get(position).getTitle());
                threePictureViewHolder.threePictureDigest.setText(data.get(position).getDigest());

                break;
        }

        return convertView;
    }


    //新建第一个缓存类
    public class OnePictureViewHolder {
        SimpleDraweeView onePictureView;
        TextView onePictureTitle, onePictureDigest;
    }

    //新建第二个缓存类
    public class ThreePictureViewHolder {
        SimpleDraweeView threePictureBigView, threePictureLittleTop, threePictureLittleBotton;
        TextView threePictureTitle, threePictureDigest;
    }


}
