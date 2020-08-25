package com.ai.doc.iterator.v3;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> arrayList;
    private int expectedModCount;
    public ArrayIterator(ArrayList arrayList){
        this.cursor = 0;
        this.arrayList = arrayList;
        this.expectedModCount = arrayList.modCount;
    }
    @Override
    public boolean hasNext() {
        checkForComodification();
        return cursor < arrayList.size();
    }

    @Override
    public void next() {
        checkForComodification();
        cursor++;
    }

    @Override
    public E currentItem() {
        checkForComodification();
        return arrayList.get(cursor);
    }
    
    private void checkForComodification(){
        if (arrayList.modCount != expectedModCount){
            throw new ConcurrentModificationException();
        }
    }
    
    
    
    
    
    
    
    
    
    
}
