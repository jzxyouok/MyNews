package com.lanou.dllo.mynews.bean;

import java.util.List;

/**
 * Created by dllo on 16/3/7.
 */
public class NewsPageBean {

    /**
     * postid : PHOT3DRK000100AP
     * hasCover : false
     * hasHead : 1
     * replyCount : 7684
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_BHI9CS9HluowenwenupdateDoc
     * title : 汕头渔民捕获350斤重巨大石斑鱼
     * order : 1
     * priority : 254
     * lmodify : 2016-03-07 12:22:52
     * boardid : photoview_bbs
     * ads : [{"title":"广西现420米天坑 发现多种不知名生物","tag":"photoset","imgsrc":"http://img4.cache.netease.com/3g/2016/3/7/20160307100605367c5.jpg","subtitle":"","url":"00AP0001|112461"},{"title":"两会代表、委员的自带\"表情包\"","tag":"photoset","imgsrc":"http://img1.cache.netease.com/3g/2016/3/7/2016030712075431ce5.jpg","subtitle":"","url":"00AN0001|112485"},{"title":"女孩重病欲捐器官 术前发现有脑电波","tag":"photoset","imgsrc":"http://img3.cache.netease.com/3g/2016/3/7/201603071023465e2f6.jpg","subtitle":"","url":"00AP0001|112466"},{"title":"哈尔滨人行道结冰 行人走路如\"滑冰\"","tag":"photoset","imgsrc":"http://img1.cache.netease.com/3g/2016/3/7/201603070842226f7f8.jpg","subtitle":"","url":"00AP0001|112449"},{"title":"鄱阳湖进入枯水期 湖洲变身\u201c草原\u201d","tag":"photoset","imgsrc":"http://img4.cache.netease.com/3g/2016/3/7/20160307083542b3d4c.jpg","subtitle":"","url":"00AP0001|112443"}]
     * photosetID : 00AP0001|112500
     * template : manual
     * votecount : 6731
     * skipID : 00AP0001|112500
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://img3.cache.netease.com/3g/2016/3/7/2016030712245064ce3.jpg"},{"imgsrc":"http://img6.cache.netease.com/3g/2016/3/7/2016030712245243311.jpg"}]
     * ename : androidnews
     * tname : 头条
     * imgsrc : http://img2.cache.netease.com/3g/2016/3/7/20160307144322c9a0d.jpg
     * ptime : 2016-03-07 12:22:52
     */

    private String postid;
    private boolean hasCover;
    private int hasHead;
    private int replyCount;
    private int hasImg;
    private String digest;
    private boolean hasIcon;
    private String docid;
    private String title;
    private int order;
    private int priority;
    private String lmodify;
    private String boardid;
    private String photosetID;
    private String template;
    private int votecount;
    private String skipID;
    private String alias;
    private String skipType;
    private String cid;
    private int hasAD;
    private String ename;
    private String tname;
    private String imgsrc;
    private String ptime;
    /**
     * title : 广西现420米天坑 发现多种不知名生物
     * tag : photoset
     * imgsrc : http://img4.cache.netease.com/3g/2016/3/7/20160307100605367c5.jpg
     * subtitle :
     * url : 00AP0001|112461
     */

    private List<AdsEntity> ads;
    /**
     * imgsrc : http://img3.cache.netease.com/3g/2016/3/7/2016030712245064ce3.jpg
     */

    private List<ImgextraEntity> imgextra;

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public void setHasHead(int hasHead) {
        this.hasHead = hasHead;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public void setHasImg(int hasImg) {
        this.hasImg = hasImg;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public void setPhotosetID(String photosetID) {
        this.photosetID = photosetID;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public void setSkipID(String skipID) {
        this.skipID = skipID;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setSkipType(String skipType) {
        this.skipType = skipType;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setHasAD(int hasAD) {
        this.hasAD = hasAD;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public void setAds(List<AdsEntity> ads) {
        this.ads = ads;
    }

    public void setImgextra(List<ImgextraEntity> imgextra) {
        this.imgextra = imgextra;
    }

    public String getPostid() {
        return postid;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public int getHasHead() {
        return hasHead;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public int getHasImg() {
        return hasImg;
    }

    public String getDigest() {
        return digest;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public String getDocid() {
        return docid;
    }

    public String getTitle() {
        return title;
    }

    public int getOrder() {
        return order;
    }

    public int getPriority() {
        return priority;
    }

    public String getLmodify() {
        return lmodify;
    }

    public String getBoardid() {
        return boardid;
    }

    public String getPhotosetID() {
        return photosetID;
    }

    public String getTemplate() {
        return template;
    }

    public int getVotecount() {
        return votecount;
    }

    public String getSkipID() {
        return skipID;
    }

    public String getAlias() {
        return alias;
    }

    public String getSkipType() {
        return skipType;
    }

    public String getCid() {
        return cid;
    }

    public int getHasAD() {
        return hasAD;
    }

    public String getEname() {
        return ename;
    }

    public String getTname() {
        return tname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getPtime() {
        return ptime;
    }

    public List<AdsEntity> getAds() {
        return ads;
    }

    public List<ImgextraEntity> getImgextra() {
        return imgextra;
    }

    public static class AdsEntity {
        private String title;
        private String tag;
        private String imgsrc;
        private String subtitle;
        private String url;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public String getTag() {
            return tag;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class ImgextraEntity {
        private String imgsrc;

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getImgsrc() {
            return imgsrc;
        }
    }
}
