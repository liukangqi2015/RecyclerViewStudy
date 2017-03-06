package com.liu.recyclerviewstudy.encapsulation.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * RecyclerView的基类Adapter
 * Created by liu on 2017/3/6.
 */

public abstract class RVBaseAdapter<T> extends RecyclerView.Adapter<RVBaseViewHolder> {
    private List<T> mDatas;
    private int layoutID;
    private LayoutInflater inflater;

    public RVBaseAdapter(int layoutID, List<T> mDatas) {
        this.layoutID = layoutID;
        this.mDatas = mDatas;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        View view=inflater.inflate(layoutID,parent,false);
        return new RVBaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        setData(holder,position,mDatas);
    }

    @Override
    public int getItemCount() {
        return mDatas!=null?mDatas.size():0;
    }

    public abstract void setData(RVBaseViewHolder viewHolder,int position,List<T> data);
}
