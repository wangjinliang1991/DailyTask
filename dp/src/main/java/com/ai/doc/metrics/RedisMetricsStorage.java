package com.ai.doc.metrics;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        
    }

    @Override
    public List<RequestInfo> getRequestInfo(String apiName, long startTimeInMills, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMillis) {
        return null;
    }
}
