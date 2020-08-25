package com.ai.higher.guava;

import com.google.common.collect.ForwardingCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Collection;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class AddLoggingCollection<E> extends ForwardingCollection<E> {
    private static final Logger logger= LoggerFactory.getLogger(AddLoggingCollection.class);
    private Collection<E> originalCollection;
    public AddLoggingCollection(Collection<E> originalCollection){
        this.originalCollection = originalCollection;
    }
    @Override
    protected Collection<E> delegate() {
        return this.originalCollection;
    }

    @Override
    public boolean add(E element) {
        logger.info("add element: "+element);
        return this.delegate().add(element);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        logger.info("size of elements to add: "+collection.size());
        return this.delegate().addAll(collection);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
