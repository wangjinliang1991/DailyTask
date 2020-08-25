package com.ai.doc.iterator.snapshot;

import com.ai.doc.iterator.v2.List;

import java.util.Iterator;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class ArrayList<E> implements List<E> {
    @Override
    public Iterator<E> iterator() {
        return new SnapshotArrayIterator(this);
    }

    @Override
    public void add(E xzg) {
        //...
    }
}
