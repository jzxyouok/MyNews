package com.lanou.dllo.mynews.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.ListenBean;

import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/3/9.
 */
public class ListenPagerAdapter extends BaseAdapter {
    private List<ListenBean.VideoListEntity> data;
    private Context context;

    public ListenPagerAdapter(List<ListenBean.VideoListEntity> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void addData(List<ListenBean.VideoListEntity> datas) {
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
        final ListenViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listen, null);
            holder = new ListenViewHolder();
            holder.videoView = (VideoView) convertView.findViewById(R.id.listen_item_video_view);
            holder.title = (TextView) convertView.findViewById(R.id.listen_item_tTitle);
            holder.description = (TextView) convertView.findViewById(R.id.listen_item_description);
            holder.length = (TextView) convertView.findViewById(R.id.listen_item_lenght);
            holder.playCount = (TextView) convertView.findViewById(R.id.listen_item_playcount);
            holder.video_iv = (SimpleDraweeView) convertView.findViewById(R.id.listen_item_video_iv);
            holder.share = (ImageView) convertView.findViewById(R.id.listen_item_share);
            holder.write = (ImageView) convertView.findViewById(R.id.listen_item_write);
            convertView.setTag(holder);
        } else {
            holder = (ListenViewHolder) convertView.getTag();
        }

        holder.videoView.setVideoURI(Uri.parse(data.get(position).getMp4_url()));
        MediaController mc = new MediaController(context);
        holder.videoView.setMediaController(mc);
        holder.videoView.requestFocus();

        holder.title.setText(String.valueOf(data.get(position).getTitle()));
        holder.description.setText(String.valueOf(data.get(position).getDescription()));
        int time = data.get(position).getLength();
        holder.length.setText(time / 60 + ":" + time % 60);
        holder.playCount.setText(String.valueOf(data.get(position).getPlayCount()));
        holder.video_iv.setImageURI(Uri.parse(data.get(position).getCover()));
        holder.video_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.video_iv.setVisibility(View.GONE);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });

        return convertView;
    }

    public class ListenViewHolder {

//        playCount播放数
//        description 描述
//        title 标题
//        mp4_url 视频网址
//        length 时长（秒）

        VideoView videoView;
        TextView title, description, length, playCount;
        SimpleDraweeView video_iv;
        ImageView share, write;

    }

    private void showShare() {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(context.getString(R.string.ssdk_oks_share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(context.getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(context);
    }
}
