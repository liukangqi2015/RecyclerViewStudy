package com.liu.recyclerviewstudy.encapsulation.base;

/**
 * 实现Cell的基类
 * Created by liu on 2017/2/17.
 */

public abstract class RVBaseCell<T> implements Cell {
    public T mData;

    public RVBaseCell(T t){
        mData = t;
    }
}
