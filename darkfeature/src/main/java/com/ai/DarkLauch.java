package com.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 框架的顶层入口
 * @Author: wangjl
 * @Date: 2020/8/25
 * @Version: 1.0
 **/
public class DarkLauch {
    private static final Logger log = LoggerFactory.getLogger(DarkLauch.class);
    private static final int DEFAULT_RULE_UPDATE_TIME_INTERVAL = 60;//in second
    private DarkRule rule;
    private ScheduledExecutorService executor;
    public DarkLauch(int ruleUpdateTimeInterval){
        loadRule();
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                loadRule();
            }
        },ruleUpdateTimeInterval,ruleUpdateTimeInterval, TimeUnit.SECONDS);
    }
    
    public DarkLauch(){
        this(DEFAULT_RULE_UPDATE_TIME_INTERVAL);
    }
    private void loadRule(){
        //将灰度规则配置文件dark-rule.yaml中的内容读取到DarkRuleConfig中
        InputStream in = null;
        DarkRuleConfig ruleConfig = null;
        try{
            in = this.getClass().getResourceAsStream("/dark-rule.yaml");
            if (in!=null){
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in,DarkRuleConfig.class);
            }
        }finally {
            if (in != null){
                try{
                    in.close();
                }catch (IOException e){
                    log.error("close file error:{}",e);
                }
            }
        }
        if (ruleConfig == null){
            throw new RuntimeException("cannot load dark rule");
        }
        //更新规则并非直接在this.rule上进行
        //而是通过创建一个新的DarkRule,然后赋值给this.rule，避免更新规则和规则查询的并发冲突问题
        DarkRule newRule = new DarkRule(ruleConfig);
        this.rule = newRule;
    }
    
    public DarkFeature getDarkFeature(String featureKey){
        DarkFeature darkFeature = this.rule.getDarkFeature(featureKey);
        return darkFeature;
    }
}
