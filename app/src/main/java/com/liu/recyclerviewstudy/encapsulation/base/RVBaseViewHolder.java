package com.liu.recyclerviewstudy.encapsulation.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * ViewHolder基类
 * Created by liu on 2017/2/17.
 */

public class RVBaseViewHolder extends RecyclerView.ViewHolder {
    private View mItemView;
    //用来存放Item中的View，避免每一次都find View
    private SparseArray<View> viewSparseArray;

    public RVBaseViewHolder(View itemView) {
        super(itemView);
        mItemView=itemView;
        viewSparseArray=new SparseArray<>();
    }

    /**
     * 得到ItemView
     * @return itemView
     */
    public View getItemView(){
        return mItemView;
    }

    /**
     * 得到Item中的View
     * @param resId view的id
     * @return view
     */
    protected <T extends View> T getView(int resId){
        View view=viewSparseArray.get(resId);
        if (view==null){
            view=mItemView.findViewById(resId);
            viewSparseArray.put(resId,view);
        }
        return (T)view;
    }

}
