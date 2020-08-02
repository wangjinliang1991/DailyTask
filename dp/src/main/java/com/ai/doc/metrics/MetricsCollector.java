package com.ai.doc.metrics;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口而非实现编程

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage){
        this.metricsStorage = metricsStorage;
    }

    //用一个方法代替最小原型中的两个方法
    public void recordRequest(RequestInfo requestInfo){
        if(requestInfo==null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
