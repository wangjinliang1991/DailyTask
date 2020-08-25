package com.ai.doc.iterator.snapshot;


import java.util.Iterator;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class SnapshotArrayIterator<E> implements Iterator<E> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {//返回当前元素，且游标后移一位
        //...
    }
}
