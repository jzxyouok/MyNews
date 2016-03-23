package com.lanou.dllo.mynews.bean;

import java.util.List;

/**
 * Created by dllo on 16/3/4.
 */
public class TopicBean {
    private DataEntity data;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * expertId : EX2038553209071753842
         * alias : 我是急诊医生李冬祎，关于人大代表提出的医疗分级，问我吧！
         * stitle :
         * picurl : http://dingyue.nosdn.127.net/ld4BL=M94EG5ZFPE0lIKjJls8HfmOvh=MGEiwDA=AS9EW1457066254086.jpg
         * name : 李冬祎
         * description : 毕业于北京首都医科大学，获得急诊专业硕士学位，曾在北京SOS国际救援中心担任急诊医生及飞行转运医生，明德医院急诊全科医生，具有近15年的急诊从医经验。
         * headpicurl : http://dingyue.nosdn.127.net/kdFAV9YVPr7IDp0NZFY6UprcGbbDLHAKRtMfW3hiOwTx41452051112078.jpg
         * classification : 健康
         * state : 1
         * expertState : 1
         * concernCount : 35347
         * createTime : 1452480900733
         * title : 急诊医生
         * questionCount : 756
         * answerCount : 494
         */

        private List<ExpertListEntity> expertList;

        public void setExpertList(List<ExpertListEntity> expertList) {
            this.expertList = expertList;
        }

        public List<ExpertListEntity> getExpertList() {
            return expertList;
        }

        public static class ExpertListEntity {
            private String expertId;
            private String alias;//背景图下面的字
            private String stitle;
            private String picurl;//背景图
            private String name;
            private String description;//简介
            private String headpicurl;//头像
            private String classification;//健康
            private int state;
            private int expertState;
            private int concernCount;//多少人关注
            private long createTime;
            private String title;//职业
            private int questionCount;//问题数
            private int answerCount;//回答数

            public void setExpertId(String expertId) {
                this.expertId = expertId;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public void setStitle(String stitle) {
                this.stitle = stitle;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setHeadpicurl(String headpicurl) {
                this.headpicurl = headpicurl;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }

            public void setState(int state) {
                this.state = state;
            }

            public void setExpertState(int expertState) {
                this.expertState = expertState;
            }

            public void setConcernCount(int concernCount) {
                this.concernCount = concernCount;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setQuestionCount(int questionCount) {
                this.questionCount = questionCount;
            }

            public void setAnswerCount(int answerCount) {
                this.answerCount = answerCount;
            }

            public String getExpertId() {
                return expertId;
            }

            public String getAlias() {
                return alias;
            }

            public String getStitle() {
                return stitle;
            }

            public String getPicurl() {
                return picurl;
            }

            public String getName() {
                return name;
            }

            public String getDescription() {
                return description;
            }

            public String getHeadpicurl() {
                return headpicurl;
            }

            public String getClassification() {
                return classification;
            }

            public int getState() {
                return state;
            }

            public int getExpertState() {
                return expertState;
            }

            public int getConcernCount() {
                return concernCount;
            }

            public long getCreateTime() {
                return createTime;
            }

            public String getTitle() {
                return title;
            }

            public int getQuestionCount() {
                return questionCount;
            }

            public int getAnswerCount() {
                return answerCount;
            }
        }
    }
}
