package com.ai.doc.iterator.v3;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/19
 * @Version:
 **/
public interface Iterator<E> {
    boolean hasNext();
    void next();//将游标后移一位元素
    E currentItem();//返回当前游标指向的元素
}
