package com.liu.recyclerviewstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liu.recyclerviewstudy.R;
import com.liu.recyclerviewstudy.model.Krystal;
import com.liu.recyclerviewstudy.myinterface.OnItemClickListener;

import java.util.List;

/**
 * Created by lkq on 2016/9/14.
 */
public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {
    private List<Krystal> data;

    private OnItemClickListener onItemclickListener;

    public MoreAdapter(List<Krystal> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.more_recyclerview_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name_tv.setText(data.get(position).getName());
        holder.iv.setImageResource(data.get(position).getImgId());
        if (onItemclickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemclickListener.onItemClickListener(view,position);
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemclickListener){
        this.onItemclickListener=onItemclickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 移除一个item
     * @param position
     */
    public void removeItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 增加一个Item
     * @param newKrystal
     * @param position
     */
    public void addItem(Krystal newKrystal,int position){
        data.add(position,newKrystal);
        notifyItemInserted(position);
    }

    public void changeItem(int positon){
        data.get(positon).setName("ChangeKrystal");
        notifyItemChanged(positon);
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
