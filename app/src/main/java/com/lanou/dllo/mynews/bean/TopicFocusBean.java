package com.lanou.dllo.mynews.bean;

import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by dllo on 16/3/19.
 */
public class TopicFocusBean {
    private String headPicurl,picurl;
    private String title,name,alias;

    public String getHeadPicurl() {
        return headPicurl;
    }

    public void setHeadPicurl(String headPicurl) {
        this.headPicurl = headPicurl;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
