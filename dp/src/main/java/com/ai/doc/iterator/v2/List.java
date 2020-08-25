package com.ai.doc.iterator.v2;

import com.ai.doc.iterator.v1.Iterator;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public interface List<E> {
    Iterator iterator();

    void add(E xzg);
    //..省略其他接口函数...
}
