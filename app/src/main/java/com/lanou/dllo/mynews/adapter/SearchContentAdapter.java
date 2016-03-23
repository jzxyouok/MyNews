package com.lanou.dllo.mynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.bean.SearchContentBean;

import java.util.List;

/**
 * Created by dllo on 16/3/21.
 */
public class SearchContentAdapter extends RecyclerView.Adapter<SearchContentAdapter.MyContentViewHolder> {
    private List<SearchContentBean.DocEntity.ResultEntity> data;
    private SearchContentBean.DocEntity.ResultEntity bean;

    public SearchContentAdapter(List<SearchContentBean.DocEntity.ResultEntity> data) {
        this.data = data;
    }

    @Override
    public MyContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_content,null);
        return new MyContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyContentViewHolder holder, int position) {
        bean = data.get(position);
        holder.title.setText(Html.fromHtml(bean.getTitle()));

    }

    @Override
    public int getItemCount() {
         return data != null && data.size() > 0 ? data.size() : 0;
    }

    class MyContentViewHolder extends RecyclerView.ViewHolder{
        private TextView title;

        public MyContentViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_search_title);
        }
    }
}
