package com.ai.doc.chonggou1.metrics3;

import com.ai.doc.chonggou1.metricsv2.Aggregator;
import com.ai.doc.chonggou1.metricsv2.EmailViewer;
import com.ai.doc.chonggou1.metricsv2.StatViewer;
import com.ai.doc.metrics.MetricsStorage;
import com.ai.doc.metrics.RedisMetricsStorage;
import com.ai.doc.metrics.RequestInfo;
import com.ai.doc.metrics.RequestStat;
import com.google.common.annotations.VisibleForTesting;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/9
 * @Version: 1.0
 **/
public class EmailReporter extends ScheduledReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;
    
    //兼顾代码的易用性，新增一个封装了默认依赖的构造方法
    public EmailReporter(List<String> emailToAddresses){
        this(new RedisMetricsStorage(),new Aggregator(),new EmailViewer(emailToAddresses));
    }

    //兼顾灵活性和代码的可测试性，这个构造方法继续保留
    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }


    public void startDailyReport() {
        //new Date()获取当前时间
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReporter(startTimeInMillis,endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
    
    @VisibleForTesting
    protected Date trimTimeFieldsToZeroOfNextDay(Date date){
        Calendar calendar = Calendar.getInstance();//这里可以获取当前时间
        calendar.setTime(date);//重新设置时间
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
