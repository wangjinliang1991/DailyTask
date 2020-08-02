package com.ai.doc.metrics;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;
    
    public ConsoleReporter(MetricsStorage metricsStorage){
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    //第4个代码逻辑：定时触发1,2,3代码逻辑的执行
    public void startRepeatedReport(long periodInSeconds, final long durationInSeconds){
        executor.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run(){
                //第1个代码逻辑：根据给定的时间区间，从数据库拉取数据
                long durationInMills = durationInSeconds*1000;
                long endTimeInMills = System.currentTimeMillis();
                long startTimeInMills = endTimeInMills-durationInMills;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMills,endTimeInMills);
                Map<String, RequestStat> stats = new HashMap<>();
                for(Map.Entry<String,List<RequestInfo>> entry:requestInfos.entrySet()){
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    //第2个代码逻辑：根据原始数据，计算得到统计数据
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi,durationInMills);
                    stats.put(apiName,requestStat);
                }
                //第3个代码逻辑：将统计数据显示到终端（命令行或邮件）
                System.out.println("Time Span: ["+startTimeInMills+", "+endTimeInMills);
                Gson gson = new Gson();
                System.out.println(gson.toJson(stats));
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
