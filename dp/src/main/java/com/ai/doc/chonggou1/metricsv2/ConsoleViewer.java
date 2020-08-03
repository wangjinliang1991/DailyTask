package com.ai.doc.chonggou1.metricsv2;

import com.ai.doc.metrics.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/3
 * @Version: 1.0
 **/
public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("Time Span: ["+startTimeInMillis+", "+endTimeInMillis);
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
