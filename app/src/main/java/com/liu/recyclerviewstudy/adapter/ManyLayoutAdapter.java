package com.liu.recyclerviewstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liu.recyclerviewstudy.R;
import com.liu.recyclerviewstudy.model.Krystal;

import java.util.ArrayList;
import java.util.List;

/**
 * 多Item布局的Adapter
 * Created by lkq on 2016/9/20.
 */
public class ManyLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int[] ITEM_TYPE={0,1};

    private List<Krystal> data=new ArrayList<>();

    public ManyLayoutAdapter(List<Krystal> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ITEM_TYPE[0]){
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.more_recyclerview_item,parent,false);
            return new ViewHolder(itemView);
        }else {
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.many_layout_recyclerview_item,parent,false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            return new ViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).name_tv.setText(data.get(position).getName());
            ((ViewHolder) holder).iv.setImageResource(data.get(position).getImgId());
        }
    }

    @Override
    public int getItemViewType(int position) {
       return ITEM_TYPE[position%ITEM_TYPE.length];
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView name_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv= ((ImageView) itemView.findViewById(R.id.iv));
            name_tv= ((TextView) itemView.findViewById(R.id.name_tv));
        }
    }
}
