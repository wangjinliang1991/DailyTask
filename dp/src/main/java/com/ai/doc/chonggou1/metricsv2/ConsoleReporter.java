package com.ai.doc.chonggou1.metricsv2;

import com.ai.doc.metrics.MetricsStorage;
import com.ai.doc.metrics.RequestInfo;
import com.ai.doc.metrics.RequestStat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/3
 * @Version: 1.0
 **/
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;
    private Aggregator aggregator;
    private StatViewer viewer;

    public ConsoleReporter(MetricsStorage metricsStorage,  Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.aggregator = aggregator;
        this.viewer = viewer;
    }
    
    public void startRepeatedReport(long periodInSeconds, final long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMills = durationInSeconds * 1000;
                long endTimeInMills = System.currentTimeMillis();
                long startTimeInMills = endTimeInMills - durationInMills;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMills, endTimeInMills);
                Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos,durationInMills);
                viewer.output(requestStats, startTimeInMills, endTimeInMills);
            }
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
