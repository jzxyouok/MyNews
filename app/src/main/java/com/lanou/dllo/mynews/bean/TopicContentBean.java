package com.lanou.dllo.mynews.bean;

import java.util.List;

/**
 * Created by dllo on 16/3/16.
 */
public class TopicContentBean {

    private String message;

    private DataEntity data;

    private int code;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public DataEntity getData() {

        return data;
    }


    public int getCode() {
        return code;
    }

    public static class DataEntity {

        private ExpertEntity expert;


        private List<HotListEntity> hotList;


        private List<LatestListEntity> latestList;

        public void setExpert(ExpertEntity expert) {
            this.expert = expert;
        }

        public void setHotList(List<HotListEntity> hotList) {
            this.hotList = hotList;
        }

        public void setLatestList(List<LatestListEntity> latestList) {
            this.latestList = latestList;
        }

        public ExpertEntity getExpert() {
            return expert;
        }

        public List<HotListEntity> getHotList() {
            return hotList;
        }

        public List<LatestListEntity> getLatestList() {
            return latestList;
        }

        public static class ExpertEntity {
            private String expertId;
            private String alias;
            private String stitle;
            private String picurl;
            private String name;
            private String description;
            private String headpicurl;
            private String classification;
            private int state;
            private int expertState;
            private int concernCount;
            private long createTime;
            private String title;
            private int questionCount;
            private int answerCount;
            /**
             * docid : BI45999J0001124J
             * title : 交通部:明确支持顺风车和拼车
             * topicid : 00961EVJ
             * skipId :
             * skipType :
             * ptime : 2016-03-14 10:57:19.0
             */

            private List<RelatedNewsEntity> relatedNews;

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

            public void setRelatedNews(List<RelatedNewsEntity> relatedNews) {
                this.relatedNews = relatedNews;
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

            public List<RelatedNewsEntity> getRelatedNews() {
                return relatedNews;
            }

            public static class RelatedNewsEntity {
                private String docid;
                private String title;
                private String topicid;
                private String skipId;
                private String skipType;
                private String ptime;

                public void setDocid(String docid) {
                    this.docid = docid;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setTopicid(String topicid) {
                    this.topicid = topicid;
                }

                public void setSkipId(String skipId) {
                    this.skipId = skipId;
                }

                public void setSkipType(String skipType) {
                    this.skipType = skipType;
                }

                public void setPtime(String ptime) {
                    this.ptime = ptime;
                }

                public String getDocid() {
                    return docid;
                }

                public String getTitle() {
                    return title;
                }

                public String getTopicid() {
                    return topicid;
                }

                public String getSkipId() {
                    return skipId;
                }

                public String getSkipType() {
                    return skipType;
                }

                public String getPtime() {
                    return ptime;
                }
            }
        }

        public static class HotListEntity {
            /**
             * questionId : QUESTION03731167471792542716
             * content : 你对任志强事件怎么看？
             * relatedExpertId : EX5017331164679100666
             * userName : 天涯W1QE
             * userHeadPicUrl :
             * state : replied
             * cTime : 1457530928658
             */

            private QuestionEntity question;
            /**
             * answerId : ANSWER9055584683078561450
             * board : 3g_bbs
             * commentId : BHPGN7L8009617BE
             * relatedQuestionId : QUESTION03731167471792542716
             * content : 任志強作为党员的确有需要注意的方面。党章规定党员有维护党的领导人威信的要求（大意）。他说话过随意。但我反对对任无限上纲，用文革那套来对待任。
             * specialistName : 杨爱珍
             * specialistHeadPicUrl : http://dingyue.nosdn.127.net/=FPQEIa3ydOzrLaO5KXcSa2O4rB7yxcrXXVd2E3qXCk781457405941068.jpg
             * supportCount : 15
             * replyCount : 0
             * cTime : 1457568432065
             */

            private AnswerEntity answer;

            public void setQuestion(QuestionEntity question) {
                this.question = question;
            }

            public void setAnswer(AnswerEntity answer) {
                this.answer = answer;
            }

            public QuestionEntity getQuestion() {
                return question;
            }

            public AnswerEntity getAnswer() {
                return answer;
            }

            public static class QuestionEntity {
                private String questionId;
                private String content;
                private String relatedExpertId;
                private String userName;
                private String userHeadPicUrl;
                private String state;
                private long cTime;

                public void setQuestionId(String questionId) {
                    this.questionId = questionId;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public void setRelatedExpertId(String relatedExpertId) {
                    this.relatedExpertId = relatedExpertId;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public void setUserHeadPicUrl(String userHeadPicUrl) {
                    this.userHeadPicUrl = userHeadPicUrl;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public void setCTime(long cTime) {
                    this.cTime = cTime;
                }

                public String getQuestionId() {
                    return questionId;
                }

                public String getContent() {
                    return content;
                }

                public String getRelatedExpertId() {
                    return relatedExpertId;
                }

                public String getUserName() {
                    return userName;
                }

                public String getUserHeadPicUrl() {
                    return userHeadPicUrl;
                }

                public String getState() {
                    return state;
                }

                public long getCTime() {
                    return cTime;
                }
            }

            public static class AnswerEntity {
                private String answerId;
                private String board;
                private String commentId;
                private String relatedQuestionId;
                private String content;
                private String specialistName;
                private String specialistHeadPicUrl;
                private int supportCount;
                private int replyCount;
                private long cTime;

                public void setAnswerId(String answerId) {
                    this.answerId = answerId;
                }

                public void setBoard(String board) {
                    this.board = board;
                }

                public void setCommentId(String commentId) {
                    this.commentId = commentId;
                }

                public void setRelatedQuestionId(String relatedQuestionId) {
                    this.relatedQuestionId = relatedQuestionId;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public void setSpecialistName(String specialistName) {
                    this.specialistName = specialistName;
                }

                public void setSpecialistHeadPicUrl(String specialistHeadPicUrl) {
                    this.specialistHeadPicUrl = specialistHeadPicUrl;
                }

                public void setSupportCount(int supportCount) {
                    this.supportCount = supportCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public void setCTime(long cTime) {
                    this.cTime = cTime;
                }

                public String getAnswerId() {
                    return answerId;
                }

                public String getBoard() {
                    return board;
                }

                public String getCommentId() {
                    return commentId;
                }

                public String getRelatedQuestionId() {
                    return relatedQuestionId;
                }

                public String getContent() {
                    return content;
                }

                public String getSpecialistName() {
                    return specialistName;
                }

                public String getSpecialistHeadPicUrl() {
                    return specialistHeadPicUrl;
                }

                public int getSupportCount() {
                    return supportCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public long getCTime() {
                    return cTime;
                }
            }
        }

        public static class LatestListEntity {
            /**
             * questionId : QUESTION2076564338752062281
             * content : 工会不是组织看电影的组织吗？
             * relatedExpertId : EX5017331164679100666
             * userName : 网易网友
             * userHeadPicUrl :
             * state : replied
             * cTime : 1458052595981
             */

            private QuestionEntity question;
            /**
             * answerId : ANSWER2094934606222295336
             * board : 3g_bbs
             * commentId : BI91CJOP009617BE
             * relatedQuestionId : QUESTION2076564338752062281
             * content : 故意的吧。答案在你心中
             * specialistName : 杨爱珍
             * specialistHeadPicUrl : http://dingyue.nosdn.127.net/=FPQEIa3ydOzrLaO5KXcSa2O4rB7yxcrXXVd2E3qXCk781457405941068.jpg
             * supportCount : 0
             * replyCount : 0
             * cTime : 1458088451769
             */

            private AnswerEntity answer;

            public void setQuestion(QuestionEntity question) {
                this.question = question;
            }

            public void setAnswer(AnswerEntity answer) {
                this.answer = answer;
            }

            public QuestionEntity getQuestion() {
                return question;
            }

            public AnswerEntity getAnswer() {
                return answer;
            }

            public static class QuestionEntity {
                private String questionId;
                private String content;
                private String relatedExpertId;
                private String userName;
                private String userHeadPicUrl;
                private String state;
                private long cTime;

                public void setQuestionId(String questionId) {
                    this.questionId = questionId;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public void setRelatedExpertId(String relatedExpertId) {
                    this.relatedExpertId = relatedExpertId;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public void setUserHeadPicUrl(String userHeadPicUrl) {
                    this.userHeadPicUrl = userHeadPicUrl;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public void setCTime(long cTime) {
                    this.cTime = cTime;
                }

                public String getQuestionId() {
                    return questionId;
                }

                public String getContent() {
                    return content;
                }

                public String getRelatedExpertId() {
                    return relatedExpertId;
                }

                public String getUserName() {
                    return userName;
                }

                public String getUserHeadPicUrl() {
                    return userHeadPicUrl;
                }

                public String getState() {
                    return state;
                }

                public long getCTime() {
                    return cTime;
                }
            }

            public static class AnswerEntity {
                private String answerId;
                private String board;
                private String commentId;
                private String relatedQuestionId;
                private String content;
                private String specialistName;
                private String specialistHeadPicUrl;
                private int supportCount;
                private int replyCount;
                private long cTime;

                public void setAnswerId(String answerId) {
                    this.answerId = answerId;
                }

                public void setBoard(String board) {
                    this.board = board;
                }

                public void setCommentId(String commentId) {
                    this.commentId = commentId;
                }

                public void setRelatedQuestionId(String relatedQuestionId) {
                    this.relatedQuestionId = relatedQuestionId;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public void setSpecialistName(String specialistName) {
                    this.specialistName = specialistName;
                }

                public void setSpecialistHeadPicUrl(String specialistHeadPicUrl) {
                    this.specialistHeadPicUrl = specialistHeadPicUrl;
                }

                public void setSupportCount(int supportCount) {
                    this.supportCount = supportCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public void setCTime(long cTime) {
                    this.cTime = cTime;
                }

                public String getAnswerId() {
                    return answerId;
                }

                public String getBoard() {
                    return board;
                }

                public String getCommentId() {
                    return commentId;
                }

                public String getRelatedQuestionId() {
                    return relatedQuestionId;
                }

                public String getContent() {
                    return content;
                }

                public String getSpecialistName() {
                    return specialistName;
                }

                public String getSpecialistHeadPicUrl() {
                    return specialistHeadPicUrl;
                }

                public int getSupportCount() {
                    return supportCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public long getCTime() {
                    return cTime;
                }
            }
        }
    }
}
