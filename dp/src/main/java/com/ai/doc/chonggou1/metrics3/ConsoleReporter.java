package com.ai.doc.chonggou1.metrics3;

import com.ai.doc.chonggou1.metricsv2.Aggregator;
import com.ai.doc.chonggou1.metricsv2.ConsoleViewer;
import com.ai.doc.chonggou1.metricsv2.StatViewer;
import com.ai.doc.metrics.MetricsStorage;
import com.ai.doc.metrics.RedisMetricsStorage;
import com.ai.doc.metrics.RequestInfo;
import com.ai.doc.metrics.RequestStat;
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
 * @Date: 2020/8/9
 * @Version: 1.0
 **/
public class ConsoleReporter extends ScheduledReporter {
    private ScheduledExecutorService executor;
    
    //兼顾代码的易用性，新增一个封装了默认依赖的构造方法
    public ConsoleReporter(){
        this(new RedisMetricsStorage(),new Aggregator(),new ConsoleViewer());
    }
    
    //兼顾灵活性和代码的可测试性，构造方法继续保留
    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }
    //省略其他代码...  todo 之后再优化
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
                    RequestStat requestStat = com.ai.doc.metrics.Aggregator.aggregate(requestInfosPerApi,durationInMills);
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
