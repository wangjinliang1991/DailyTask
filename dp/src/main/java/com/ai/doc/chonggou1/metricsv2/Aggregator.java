package com.ai.doc.chonggou1.metricsv2;

import com.ai.doc.metrics.RequestInfo;
import com.ai.doc.metrics.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class Aggregator {
    public Map<String, RequestStat> aggregate(Map<String,List<RequestInfo>> requestInfos, long durationInMills){
        Map<String,RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String,List<RequestInfo>> entry:requestInfos.entrySet()){
            String apiName =  entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi,durationInMills);
            requestStats.put(apiName,requestStat);
        }
        return requestStats;
    }
    
    private RequestStat doAggregate(List<RequestInfo> requestInfos,long durationInMillis){
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo:requestInfos){
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long)tps(respTimes.size(),durationInMillis/1000));
        return requestStat; 
    }
    
    //以下的代码的实现暂时忽略
    private double max(List<Double> dataset){
        return 0.0;
    }
    private double min(List<Double> dataset){
        return 0.0;
    }
    private double avg(List<Double> dataset){
        return 0.0;
    }
    private double percentile999(List<Double> dataset){
        return 0.0;
    }
    private double percentile99(List<Double> dataset){
        return 0.0;
    }
    private double percentile(List<Double> dataset,double ratio){
        return 0.0;
    }
    private double tps(int count,double duration){
        return 0.0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
