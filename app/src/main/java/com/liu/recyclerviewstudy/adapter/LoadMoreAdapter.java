package com.liu.recyclerviewstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liu.recyclerviewstudy.R;
import com.liu.recyclerviewstudy.model.Krystal;

import java.util.List;

/**
 * Created by lkq on 2017/1/20.
 */

public class LoadMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //底部FootView

    private List<Krystal> data;

    public LoadMoreAdapter(List<Krystal> data) {
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_recyclerview_item, parent, false);
            return new ViewHolder(itemView);
        }else if (viewType==TYPE_FOOTER){
            View foot_view=LayoutInflater.from(parent.getContext()).inflate(R.layout.load_more_foot_view, parent, false);
            return new FootViewHolder(foot_view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ((ViewHolder)holder).name_tv.setText(data.get(position).getName());
            ((ViewHolder)holder).iv.setImageResource(data.get(position).getImgId());
        }else if (holder instanceof FootViewHolder){

        }
//
    }

    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    public void addMoreItem(List<Krystal> newDatas) {
        data.addAll(newDatas);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView name_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = ((ImageView) itemView.findViewById(R.id.iv));
            name_tv = ((TextView) itemView.findViewById(R.id.name_tv));
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ProgressBar pb;

        public FootViewHolder(View itemView) {
            super(itemView);
            tv = ((TextView) itemView.findViewById(R.id.load_more_default_footer_text_view));
            pb = ((ProgressBar) itemView.findViewById(R.id.pb));
        }
    }


}
