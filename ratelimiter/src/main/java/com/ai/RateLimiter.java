package com.ai;

import com.ai.alg.RateLimitAlg;
import com.ai.rule.ApiLimit;
import com.ai.rule.TrieRateLimitRule;
import com.ai.rule.RuleConfig;
import com.ai.rule.datasource.FileRuleConfigSource;
import com.ai.rule.datasource.RuleConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);
    //为每个api在内存中存储限流计数器
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private TrieRateLimitRule rule;
    public RateLimiter(){
        //改动主要在这里：调用RuleConfigSource类来实现配置加载
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new TrieRateLimitRule(ruleConfig);
    }
    
    public boolean limit(String appId,String url) throws InternalError{
        ApiLimit apiLimit = rule.getLimit(appId,url);
        if (apiLimit==null){
            return true;
        }
        //获取api对应在内存中的限流计数器rateLimitCounter
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null){
            RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey,newRateLimitCounter);
            if (rateLimitCounter == null){
                rateLimitCounter = newRateLimitCounter;
            }
        }
        //判断是否限流
        return rateLimitCounter.tryAcquire();
    }
    
}
