package com.lanou.dllo.mynews.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dllo on 16/3/8.
 */
public class ReadRecommendBean {
    /**
     * boardid : comment_bbs
     * clkNum : 0
     * digest : 在人们的心目中，和尚作为出家人，四大皆空，而且戒律森严，应该不会和偷情之类的淫秽之事挂上勾，可是在中国古代偏偏有些和尚不仅热衷于偷情，而且还是个中高手。武则天一生男宠无数，第一个却是一个和尚薛怀义。
     * docid : BHKHDR369001DR37
     * downTimes : 1
     * id : BHKHDR369001DR37
     * img : http://p1.music.126.net/I7f1kYrH9SC6rQVz9yd26g==/18261788625927034.jpg
     * imgType : 0
     * imgsrc : http://p1.music.126.net/I7f1kYrH9SC6rQVz9yd26g==/18261788625927034.jpg
     * picCount : 14
     * pixel : 448*333
     * program : HY
     * prompt : 常读新闻，下午不犯困
     * ptime : 2016-03-08 08:57:12
     * recType : -1
     * replyCount : 97
     * replyid : BHKHDR369001DR37
     * source : 光明网
     * template : normal
     * title : 揭秘古代熟女为何喜欢与和尚偷情
     * unlikeReason : ["历史/1","虚假新闻/6","反党反社会/6","很黄很暴力/6","标题党/6","来源:光明网/4","内容重复/6"]
     * upTimes : 36
     */

    @SerializedName("推荐")
    private List<RecomEntity> recom;

    public List<RecomEntity> getRecom() {
        return recom;
    }

    public void setRecom(List<RecomEntity> recom) {
        this.recom = recom;
    }

    public static class RecomEntity {
        private String boardid;
        private int clkNum;
        private String digest;
        private String docid;
        private int downTimes;
        private String id;
        private String img;
        private int imgType;
        private String imgsrc;
        private int picCount;
        private String pixel;
        private String program;
        private String prompt;
        private String ptime;
        private int recType;
        private int replyCount;
        private String replyid;
        private String source;
        private String template;
        private String title;
        private int upTimes;
        private List<String> unlikeReason;

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public void setClkNum(int clkNum) {
            this.clkNum = clkNum;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public void setDownTimes(int downTimes) {
            this.downTimes = downTimes;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setPicCount(int picCount) {
            this.picCount = picCount;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUpTimes(int upTimes) {
            this.upTimes = upTimes;
        }

        public void setUnlikeReason(List<String> unlikeReason) {
            this.unlikeReason = unlikeReason;
        }

        public String getBoardid() {
            return boardid;
        }

        public int getClkNum() {
            return clkNum;
        }

        public String getDigest() {
            return digest;
        }

        public String getDocid() {
            return docid;
        }

        public int getDownTimes() {
            return downTimes;
        }

        public String getId() {
            return id;
        }

        public String getImg() {
            return img;
        }

        public int getImgType() {
            return imgType;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public int getPicCount() {
            return picCount;
        }

        public String getPixel() {
            return pixel;
        }

        public String getProgram() {
            return program;
        }

        public String getPrompt() {
            return prompt;
        }

        public String getPtime() {
            return ptime;
        }

        public int getRecType() {
            return recType;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public String getSource() {
            return source;
        }

        public String getTemplate() {
            return template;
        }

        public String getTitle() {
            return title;
        }

        public int getUpTimes() {
            return upTimes;
        }

        public List<String> getUnlikeReason() {
            return unlikeReason;
        }
    }
}
