package com.ai.doc.observer.v5;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;


/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();
    public EventBus(){
        this(MoreExecutors.directExecutor());
    }
    protected EventBus(Executor executor){
        this.executor = executor;
    }
    public void register(Object object){
        registry.register(object);
    }
    public void post(Object event){
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction:observerActions){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
