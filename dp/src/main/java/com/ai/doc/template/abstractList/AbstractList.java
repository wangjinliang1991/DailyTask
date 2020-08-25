package com.ai.doc.template.abstractList;

import java.util.Collection;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public abstract class AbstractList<E> {
    public boolean addAll(int index, Collection<? extends E> c){
        rangeCheckForAdd(index);
        boolean modified = false;
        for (E e:c){
            add(index++,e);
            modified = true;
        }
        return modified;
    }

    protected abstract void rangeCheckForAdd(int index);
    

    public void add(int index, E element){
        throw new UnsupportedOperationException();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
