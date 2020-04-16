package com.smart.adapter.base;

/**
 * Author: Jett
 * Date: 2020-04-16 11:25
 * Email: hydznsq@163.com
 * Des:
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId() ;

    boolean isForViewType(T item, int position) ;

    void convert(ViewHolder holder, T t, int position) ;
}
