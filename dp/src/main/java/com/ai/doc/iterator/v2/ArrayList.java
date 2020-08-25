package com.ai.doc.iterator.v2;

import com.ai.doc.iterator.v1.ArrayIterator;
import com.ai.doc.iterator.v1.Iterator;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ArrayList<E> implements List<E> {
    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void add(E xzg) {
        
    }
}
