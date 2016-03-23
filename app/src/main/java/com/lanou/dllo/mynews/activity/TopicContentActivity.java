package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.TopicContentPagerAdapter;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.base.NestedListView;
import com.lanou.dllo.mynews.bean.TopicContentBean;
import com.lanou.dllo.mynews.fragment.TopicFragment;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/3/16.
 */
public class TopicContentActivity extends BaseActivity implements NetListener {
    private String expertId;
    private TopicContentBean beans = new TopicContentBean();
    private NestedListView listView;
    private SimpleDraweeView picurl,headpicurl;
    private ImageView back,share;
    private TextView alias,concernCount,name,title,description,questionCount,answerCount;
    private TopicContentPagerAdapter topicContentPagerAdapter;
    private TopicContentBean.DataEntity bean;


    @Override
    protected void initData() {

        Intent intent = getIntent();
        expertId = intent.getStringExtra("expertId");
        NetHelper netHelper = new NetHelper();
        netHelper.getDataFromNet("http://c.m.163.com/newstopic/qa/"+expertId+".html",null,this, TopicContentBean.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.topic_content_listview);
        picurl = bindView(R.id.topic_content_picurl);
        headpicurl = bindView(R.id.topic_content_headpicurl);
        alias = bindView(R.id.topic_content_alias);
        concernCount = bindView(R.id.topic_content_concernCount);
        name = bindView(R.id.topic_content_name);
        title = bindView(R.id.topic_content_title);
        description = bindView(R.id.topic_content_description);
        back = bindView(R.id.topic_content_back);
        questionCount = bindView(R.id.item_topic_content_questionCount);
        answerCount = bindView(R.id.item_topic_content_answerCount);
        share = bindView(R.id.topic_content_share);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_topic_content;
    }

    @Override
    public void getSuccess(Object o) {
        beans = (TopicContentBean) o;
        bean = new TopicContentBean.DataEntity();
        bean = beans.getData();
        if (bean.getExpert().getPicurl() != null){
            picurl.setImageURI(Uri.parse(bean.getExpert().getPicurl()));
        }
        headpicurl.setImageURI(Uri.parse(bean.getExpert().getHeadpicurl()));
        alias.setText(bean.getExpert().getAlias());
        concernCount.setText(String.valueOf(bean.getExpert().getConcernCount()) + "关注");
        name.setText(bean.getExpert().getName());
        title.setText(bean.getExpert().getTitle());
        description.setText(bean.getExpert().getDescription());
        questionCount.setText(String.valueOf(bean.getExpert().getQuestionCount())+"提问");
        answerCount.setText(String.valueOf(bean.getExpert().getAnswerCount())+"回答");

        topicContentPagerAdapter = new TopicContentPagerAdapter(bean,this);
        listView.setAdapter(topicContentPagerAdapter);

    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList t) {

    }
    private void showShare(){
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.ssdk_oks_share));
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
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }
}
