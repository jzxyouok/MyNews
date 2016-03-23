package com.lanou.dllo.mynews.bean;

import java.util.List;

/**
 * Created by dllo on 16/3/21.
 */
public class SearchHotWordBean {

    /**
     * hotWord : 吴奇隆刘诗诗今日大婚
     */

    private List<HotWordListEntity> hotWordList;

    public void setHotWordList(List<HotWordListEntity> hotWordList) {
        this.hotWordList = hotWordList;
    }

    public List<HotWordListEntity> getHotWordList() {
        return hotWordList;
    }

    public static class HotWordListEntity {
        private String hotWord;

        public void setHotWord(String hotWord) {
            this.hotWord = hotWord;
        }

        public String getHotWord() {
            return hotWord;
        }
    }
}
