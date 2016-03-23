package com.lanou.dllo.mynews.bean;

import java.util.List;

/**
 * Created by dllo on 16/3/20.
 */
public class NewsContentBean {

    private String body;
    private int replyCount;
    private String digest;
    private String dkeys;
    private String ec;
    private String docid;
    /**
     * alias : 通达民情，生活至上
     * tname : 信息时报
     * ename : xinxishibao
     * tid : T1402647381772
     */

    private SourceinfoEntity sourceinfo;
    private boolean picnews;
    private String title;
    private String tid;
    private String template;
    private int threadVote;
    private int threadAgainst;
    private String replyBoard;
    private String source;
    private String voicecomment;
    private boolean hasNext;
    private String ptime;
    private List<?> users;
    private List<?> ydbaike;
    private List<?> link;
    private List<?> votes;
    /**
     * ref : <!--IMG#0-->
     * pixel : 852*1280
     * alt : 范冰冰送拥抱 冯小刚:胸很大啊
     * src : http://img4.cache.netease.com/photo/0003/2016-03-16/BI9QNIQ200AJ0003.jpg
     * photosetID : 0003|591263
     */

    private List<ImgEntity> img;
    /**
     * hasCover : false
     * subnum : 超过1000万
     * alias : Entertainment
     * tname : 娱乐
     * ename : yule
     * tid : T1348648517839
     * cid : C1348648351901
     */

    private List<TopiclistNewsEntity> topiclist_news;
    /**
     * hasCover : false
     * subnum : 超过1000万
     * alias : 尖峰娱论、八卦聚焦
     * tname : 网易明星
     * ename : mingxing
     * tid : T1348648624173
     * cid : C1378977941637
     */

    private List<TopiclistEntity> topiclist;
    /**
     * word : 冯小刚导演
     */

    private List<KeywordSearchEntity> keyword_search;
    /**
     * commentid : BCMNDQSP008535RB
     * ref : <!--VIDEO#0-->
     * topicid : 0085
     * cover : http://vimg2.ws.126.net/image/snapshot/2016/1/S/Q/VBCMNDQSQ.jpg
     * alt : 范冰冰与冯小刚进酒吧 素颜合影皮肤白
     * url_mp4 : http://flv2.bn.netease.com/videolib3/1601/18/KpwYs4779/SD/KpwYs4779-mobile.mp4
     * broadcast : in
     * videosource : 新媒体
     * commentboard : video_bbs
     * appurl :
     * url_m3u8 : http://flv2.bn.netease.com/videolib3/1601/18/KpwYs4779/SD/KpwYs4779-mobile.mp4
     * size :
     */

    private List<VideoEntity> video;
    private List<?> boboList;
    /**
     * id : BIBLGG2F00032DGD
     * title : 范冰冰演"潘金莲"：最大困难是克服洋气的脸
     * source : 新华网
     * imgsrc : http://p1.music.126.net/14AqnkF248UOHW44U5QeAg==/18285977881750930.jpg
     * type : doc
     * ptime : 2016-03-17 08:35:45
     * href :
     */

    private List<RelativeSysEntity> relative_sys;
    private List<?> apps;

    public void setBody(String body) {
        this.body = body;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setDkeys(String dkeys) {
        this.dkeys = dkeys;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public void setSourceinfo(SourceinfoEntity sourceinfo) {
        this.sourceinfo = sourceinfo;
    }

    public void setPicnews(boolean picnews) {
        this.picnews = picnews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public void setThreadAgainst(int threadAgainst) {
        this.threadAgainst = threadAgainst;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setVoicecomment(String voicecomment) {
        this.voicecomment = voicecomment;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public void setUsers(List<?> users) {
        this.users = users;
    }

    public void setYdbaike(List<?> ydbaike) {
        this.ydbaike = ydbaike;
    }

    public void setLink(List<?> link) {
        this.link = link;
    }

    public void setVotes(List<?> votes) {
        this.votes = votes;
    }

    public void setImg(List<ImgEntity> img) {
        this.img = img;
    }

    public void setTopiclist_news(List<TopiclistNewsEntity> topiclist_news) {
        this.topiclist_news = topiclist_news;
    }

    public void setTopiclist(List<TopiclistEntity> topiclist) {
        this.topiclist = topiclist;
    }

    public void setKeyword_search(List<KeywordSearchEntity> keyword_search) {
        this.keyword_search = keyword_search;
    }

    public void setVideo(List<VideoEntity> video) {
        this.video = video;
    }

    public void setBoboList(List<?> boboList) {
        this.boboList = boboList;
    }

    public void setRelative_sys(List<RelativeSysEntity> relative_sys) {
        this.relative_sys = relative_sys;
    }

    public void setApps(List<?> apps) {
        this.apps = apps;
    }

    public String getBody() {
        return body;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public String getDigest() {
        return digest;
    }

    public String getDkeys() {
        return dkeys;
    }

    public String getEc() {
        return ec;
    }

    public String getDocid() {
        return docid;
    }

    public SourceinfoEntity getSourceinfo() {
        return sourceinfo;
    }

    public boolean isPicnews() {
        return picnews;
    }

    public String getTitle() {
        return title;
    }

    public String getTid() {
        return tid;
    }

    public String getTemplate() {
        return template;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public int getThreadAgainst() {
        return threadAgainst;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public String getSource() {
        return source;
    }

    public String getVoicecomment() {
        return voicecomment;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public String getPtime() {
        return ptime;
    }

    public List<?> getUsers() {
        return users;
    }

    public List<?> getYdbaike() {
        return ydbaike;
    }

    public List<?> getLink() {
        return link;
    }

    public List<?> getVotes() {
        return votes;
    }

    public List<ImgEntity> getImg() {
        return img;
    }

    public List<TopiclistNewsEntity> getTopiclist_news() {
        return topiclist_news;
    }

    public List<TopiclistEntity> getTopiclist() {
        return topiclist;
    }

    public List<KeywordSearchEntity> getKeyword_search() {
        return keyword_search;
    }

    public List<VideoEntity> getVideo() {
        return video;
    }

    public List<?> getBoboList() {
        return boboList;
    }

    public List<RelativeSysEntity> getRelative_sys() {
        return relative_sys;
    }

    public List<?> getApps() {
        return apps;
    }

    public static class SourceinfoEntity {
        private String alias;
        private String tname;
        private String ename;
        private String tid;

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getAlias() {
            return alias;
        }

        public String getTname() {
            return tname;
        }

        public String getEname() {
            return ename;
        }

        public String getTid() {
            return tid;
        }
    }

    public static class ImgEntity {
        private String ref;
        private String pixel;
        private String alt;
        private String src;
        private String photosetID;

        public void setRef(String ref) {
            this.ref = ref;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getRef() {
            return ref;
        }

        public String getPixel() {
            return pixel;
        }

        public String getAlt() {
            return alt;
        }

        public String getSrc() {
            return src;
        }

        public String getPhotosetID() {
            return photosetID;
        }
    }

    public static class TopiclistNewsEntity {
        private boolean hasCover;
        private String subnum;
        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String cid;

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public String getSubnum() {
            return subnum;
        }

        public String getAlias() {
            return alias;
        }

        public String getTname() {
            return tname;
        }

        public String getEname() {
            return ename;
        }

        public String getTid() {
            return tid;
        }

        public String getCid() {
            return cid;
        }
    }

    public static class TopiclistEntity {
        private boolean hasCover;
        private String subnum;
        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String cid;

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public String getSubnum() {
            return subnum;
        }

        public String getAlias() {
            return alias;
        }

        public String getTname() {
            return tname;
        }

        public String getEname() {
            return ename;
        }

        public String getTid() {
            return tid;
        }

        public String getCid() {
            return cid;
        }
    }

    public static class KeywordSearchEntity {
        private String word;

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    public static class VideoEntity {
        private String commentid;
        private String ref;
        private String topicid;
        private String cover;
        private String alt;
        private String url_mp4;
        private String broadcast;
        private String videosource;
        private String commentboard;
        private String appurl;
        private String url_m3u8;
        private String size;

        public void setCommentid(String commentid) {
            this.commentid = commentid;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setUrl_mp4(String url_mp4) {
            this.url_mp4 = url_mp4;
        }

        public void setBroadcast(String broadcast) {
            this.broadcast = broadcast;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public void setCommentboard(String commentboard) {
            this.commentboard = commentboard;
        }

        public void setAppurl(String appurl) {
            this.appurl = appurl;
        }

        public void setUrl_m3u8(String url_m3u8) {
            this.url_m3u8 = url_m3u8;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getCommentid() {
            return commentid;
        }

        public String getRef() {
            return ref;
        }

        public String getTopicid() {
            return topicid;
        }

        public String getCover() {
            return cover;
        }

        public String getAlt() {
            return alt;
        }

        public String getUrl_mp4() {
            return url_mp4;
        }

        public String getBroadcast() {
            return broadcast;
        }

        public String getVideosource() {
            return videosource;
        }

        public String getCommentboard() {
            return commentboard;
        }

        public String getAppurl() {
            return appurl;
        }

        public String getUrl_m3u8() {
            return url_m3u8;
        }

        public String getSize() {
            return size;
        }
    }

    public static class RelativeSysEntity {
        private String id;
        private String title;
        private String source;
        private String imgsrc;
        private String type;
        private String ptime;
        private String href;

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getSource() {
            return source;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public String getType() {
            return type;
        }

        public String getPtime() {
            return ptime;
        }

        public String getHref() {
            return href;
        }
    }

}
