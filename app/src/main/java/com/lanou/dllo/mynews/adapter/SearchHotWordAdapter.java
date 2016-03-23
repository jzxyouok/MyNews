package com.lanou.dllo.mynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.SearchHotWordBean;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/21.
 */
public class SearchHotWordAdapter extends RecyclerView.Adapter<SearchHotWordAdapter.HotViewHolder> {
    private List<SearchHotWordBean.HotWordListEntity> data;
    private SearchHotWordBean.HotWordListEntity bean;
    private String hot;
    public SearchHotWordAdapter( List<SearchHotWordBean.HotWordListEntity> data) {
        this.data = data;
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_hot, null);
        return new HotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotViewHolder holder, int position) {
        bean = data.get(position);
        holder.hotWord.setText(bean.getHotWord());


    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class HotViewHolder extends RecyclerView.ViewHolder{
        private TextView hotWord;

        public HotViewHolder(View itemView) {
            super(itemView);
            hotWord = (TextView) itemView.findViewById(R.id.item_search_hot);
            hotWord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hot = (String) hotWord.getText();
                    EventBus.getDefault().post(hot);
                }
            });
        }
    }
}
