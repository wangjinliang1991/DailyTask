package com.ai.doc.chonggou1.metrics3;

import com.ai.doc.chonggou1.metricsv2.Aggregator;
import com.ai.doc.chonggou1.metricsv2.StatViewer;
import com.ai.doc.metrics.MetricsStorage;
import com.ai.doc.metrics.RequestInfo;
import com.ai.doc.metrics.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/9
 * @Version: 1.0
 **/
public abstract class ScheduledReporter {
    private static final long MAX_STAT_DURATION_IN_MILLIS = 10*60*1000;//10 MIN
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }
    
    protected void doStatAndReporter(long startTimeInMillis,long endTimeInMillis){
        Map<String,RequestStat> stats = doStat(startTimeInMillis,endTimeInMillis);
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos,durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

    private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeInMillis) {
        Map<String,List<RequestStat>> segmentStats = new HashMap<>();
        long segmentStartTimeInMillis = startTimeInMillis;
        while (segmentStartTimeInMillis < endTimeInMillis){
            long segmentEndTimeInMillis = segmentStartTimeInMillis + MAX_STAT_DURATION_IN_MILLIS;
            if (segmentEndTimeInMillis > endTimeInMillis){
                segmentEndTimeInMillis = endTimeInMillis;
            }
            Map<String,List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(segmentStartTimeInMillis,segmentEndTimeInMillis);
            if (requestInfos == null || requestInfos.isEmpty()){
                continue;
            }
            Map<String,RequestStat> segmentStat = aggregator.aggregate(requestInfos,segmentEndTimeInMillis-segmentStartTimeInMillis);
            addStat(segmentStats,segmentStat);
            segmentStartTimeInMillis += MAX_STAT_DURATION_IN_MILLIS;
        }
        
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String,RequestStat> aggregatedStats = aggregateStat(segmentStats,durationInMillis);
        return aggregatedStats;
    }

    private Map<String, RequestStat> aggregateStat(Map<String, List<RequestStat>> segmentStats, long durationInMillis) {
        Map<String,RequestStat> aggregatedStats = new HashMap<>();
        for (Map.Entry<String,List<RequestStat>> entry:segmentStats.entrySet()){
            String apiName = entry.getKey();
            List<RequestStat> apiStats = entry.getValue();
            double maxRespTime = Double.MAX_VALUE;
            double minRespTime = Double.MIN_VALUE;
            long count = 0;
            double sumRespTime = 0;
            for (RequestStat stat:apiStats){
                if (stat.getMaxResponseTime() > maxRespTime) maxRespTime = stat.getMaxResponseTime();
                if (stat.getMinResponseTime() < minRespTime) minRespTime = stat.getMinResponseTime();
                count += stat.getCount();
                sumRespTime +=(stat.getCount() * stat.getAvgResponseTime());
            }
            RequestStat aggregatedStat = new RequestStat();
            aggregatedStat.setMaxResponseTime(maxRespTime);
            aggregatedStat.setMinResponseTime(minRespTime);
            aggregatedStat.setAvgResponseTime(sumRespTime/count);
            aggregatedStat.setTps(count/durationInMillis*1000);
            aggregatedStats.put(apiName,aggregatedStat);
        }
        return aggregatedStats;
    }

    private void addStat(Map<String, List<RequestStat>> segmentStats, Map<String, RequestStat> segmentStat) {
        for (Map.Entry<String,RequestStat> entry:segmentStat.entrySet()){
            String apiName = entry.getKey();
            RequestStat stat = entry.getValue();
            List<RequestStat> statList = segmentStats.putIfAbsent(apiName,new ArrayList<RequestStat>());
            statList.add(stat);
        }
    }
    
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
