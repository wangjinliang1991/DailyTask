package com.ai.doc.factory;

import com.ai.doc.factory.simple2.RuleConfigParserFactory;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFulePath){
        String ruleConfigFileExtension = getFileExtension(ruleConfigFulePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser==null){
            throw new InvalidRuleConfigException("Rule config file format is not support: "+ruleConfigFulePath);
        }
        
        String configText = "";
        //从ruleConfigFilePath文件读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }
    
    private String getFileExtension(String filePath){
        //...解析文件名获取扩展名，如rule.json 返回json
        return "json";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
