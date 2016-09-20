package com.liu.recyclerviewstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private static final String TAG=MoreAdapter.class.getSimpleName();
    private List<Krystal> data;

    private OnItemClickListener onItemclickListener;

    public MoreAdapter(List<Krystal> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG,"onCreateViewHolder");
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.more_recyclerview_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.name_tv.setText(data.get(position).getName());
        holder.iv.setImageResource(data.get(position).getImgId());
        if (onItemclickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG,"onBindViewHolder--position"+position);
                    Log.i(TAG,"onBindViewHolder--AdapterPosition"+holder.getAdapterPosition());
                    //注意，这里不能传入position（当插入或删除数据的时候，这个position会错乱），需要使用getAdapterPosition()（返回的是ViewHolder在Adapter的位置,所以删除和插入数据的时候会更新)。
                    onItemclickListener.onItemClickListener(view,+holder.getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemclickListener){
        this.onItemclickListener=onItemclickListener;
    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"getItemCount"+data.size());
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

    public void changeItem(int position){
        data.get(position).setName("ChangeKrystal");
        notifyItemChanged(position);
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
