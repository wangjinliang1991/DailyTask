package com.ai.doc.metrics;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class Demo {
    public static void main(String[] args){
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60,60);

        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.addToAddress("xxx@126.com");
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register",123,10234));
        collector.recordRequest(new RequestInfo("register",223,11234));
        collector.recordRequest(new RequestInfo("register",323,12234));
        collector.recordRequest(new RequestInfo("login",23,12434));
        collector.recordRequest(new RequestInfo("login",1123,14434));

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
