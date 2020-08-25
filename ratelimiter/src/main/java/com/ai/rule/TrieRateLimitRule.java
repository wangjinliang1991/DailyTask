package com.ai.rule;

/**
 * @Description: 为提高查询速度，将限流规则组织为一种支持按照url快速查询的数据结构trie树
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class TrieRateLimitRule implements RateLimitRule{
    public TrieRateLimitRule(RuleConfig ruleConfig){
        //..
    }
    public ApiLimit getLimit(String appId,String api){
        //...
    }
}
