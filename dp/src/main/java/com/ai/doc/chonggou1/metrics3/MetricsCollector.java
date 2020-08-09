package com.ai.doc.chonggou1.metrics3;

import com.ai.doc.metrics.MetricsStorage;
import com.ai.doc.metrics.RedisMetricsStorage;
import com.ai.doc.metrics.RequestInfo;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.util.EventListener;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/9
 * @Version: 1.0
 **/
public class MetricsCollector {
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
    
    private MetricsStorage metricsStorage;
    private EventBus eventBus;
    
    //兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector(){
        this(new RedisMetricsStorage());
    }
    
    public MetricsCollector(MetricsStorage metricsStorage){
        this(metricsStorage,DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }
    
    public MetricsCollector(MetricsStorage metricsStorage,int thredNumToSaveData){
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(thredNumToSaveData));
        this.eventBus.register(new EventListener() {
        });
    }

    //用一个方法代替最小原型中的两个方法
    public void recordRequest(RequestInfo requestInfo){
        if(requestInfo==null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }
        eventBus.post(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo){
            metricsStorage.saveRequestInfo(requestInfo);
        }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
