package com.ai.doc.chonggou1.metrics3;

import com.ai.doc.chonggou1.metricsv2.EmailReporter;
import com.ai.doc.metrics.RequestInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/9
 * @Version: 1.0
 **/
public class PerfCounterTest {
    public static void main(String[] args) {
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60,60);

        List<String> emailToAddresses = new ArrayList<>();
        emailToAddresses.add("xx@126.com");
        com.ai.doc.chonggou1.metricsv2.EmailReporter emailReporter = new EmailReporter(emailToAddresses);
        emailReporter.startDailyReport();
        
        MetricsCollector collector = new MetricsCollector();
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("login", 23, 12234));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
