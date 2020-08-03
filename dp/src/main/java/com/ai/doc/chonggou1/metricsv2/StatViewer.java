package com.ai.doc.chonggou1.metricsv2;

import com.ai.doc.metrics.RequestStat;

import java.util.Map;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/3
 * @Version:
 **/
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis);
}
