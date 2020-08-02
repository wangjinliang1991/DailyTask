package com.ai.doc.metrics;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/2
 * @Version:
 **/
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfo(String apiName, long startTimeInMills, long endTimeInMillis);

    Map<String,List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMillis);
}
