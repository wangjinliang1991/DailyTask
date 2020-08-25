package com.ai.doc.factory.factory1;

import com.ai.doc.factory.IRuleConfigParser;
import com.ai.doc.factory.RuleConfig;
import com.ai.doc.factory.simple3.IRuleConfigParserFactory;
import com.ai.doc.factory.simple3.JsonRuleConfigParserFactory;
import com.ai.doc.factory.simple3.PropertiesRuleConfigParserFactory;
import com.ai.doc.factory.simple3.XmlRuleConfigParserFactory;
import com.ai.doc.factory.simple3.YamlRuleConfigParserFactory;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFulePath){
        String ruleConfigFileExtension = getFileExtension(ruleConfigFulePath);
        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)){
            parserFactory = new JsonRuleConfigParserFactory();
        }else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)){
            parserFactory = new XmlRuleConfigParserFactory();
        }else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)){
            parserFactory  = new YamlRuleConfigParserFactory();
        }else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)){
            parserFactory = new PropertiesRuleConfigParserFactory();
        }else {
            throw new InvalidRuleConfigException("Rule config file format is not support: "+ruleConfigFulePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

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
