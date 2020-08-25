package com.ai.doc.iterator.v1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> arrayList;
    public ArrayIterator(ArrayList<E> arrayList){
        this.cursor = 0;
        this.arrayList = arrayList;
    }
    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();//cursor在指向最后一个元素时，hashNext
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor >= arrayList.size()){
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
