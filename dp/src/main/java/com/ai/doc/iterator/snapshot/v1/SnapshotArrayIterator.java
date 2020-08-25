package com.ai.doc.iterator.snapshot.v1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class SnapshotArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> snapshot;
    public SnapshotArrayIterator(ArrayList<E> arrayList){
        this.cursor = 0;
        this.snapshot = new ArrayList<>();
        this.snapshot.addAll(arrayList);
    }

    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public E next() {
        E currentItem = snapshot.get(cursor);
        cursor++;
        return currentItem;
    }
}
