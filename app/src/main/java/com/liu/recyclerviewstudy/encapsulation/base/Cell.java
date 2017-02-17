package com.liu.recyclerviewstudy.encapsulation.base;

import android.view.ViewGroup;

/**
 * 一种Cell就是一种ViewType
 * Created by liu on 2017/2/17.
 */

public interface Cell {

    /**
     * 创建ViewHolder
     * @param parent ViewGroup
     * @param viewType ItemView的类型
     * @return
     */
    RVBaseViewHolder onCreatViewHolder(ViewGroup parent,int viewType);

    /**
     * 绑定数据
     * @param viewHolder ViewHolder
     * @param position 位置
     */
    void onBindViewHolder(RVBaseViewHolder viewHolder,int position);

    /**
     * 获取viewType
     * @return view的类型
     */
    int getItemType();

}
