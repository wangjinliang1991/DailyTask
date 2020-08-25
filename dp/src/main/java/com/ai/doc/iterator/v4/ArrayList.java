package com.ai.doc.iterator.v4;

import org.springframework.dao.ConcurrencyFailureException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ArrayList<E> {
    transient Object[] elementData;
    private int size;
    public Iterator<E> iterator(){
        return new Itr();
    }
    private class Itr implements Iterator<E>{
        int cursor;//index of next element to return
        int lastRet = -1;//index of last element returned; -1 or no such
        int expectedModCount = modCount;
        Itr(){}
        public boolean hasNext(){
            return cursor != size;
        }
        @SuppressWarnings("unchecked")
        public E next(){
            int i = cursor;
            if (i >= size){
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length){
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }
        
        public void remove(){
            if (lastRet < 0){
                throw new IllegalArgumentException();
            }
            checkForComodification();
            try{
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            }catch (IndexOutOfBoundsException ex){
                throw new ConcurrentModificationException();
                java.util.ArrayList
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
