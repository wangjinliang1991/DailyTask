package com.ai.doc.factory.simple2;

import com.ai.doc.factory.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class RuleConfigParserFactory {
    private static final Map<String, IRuleConfigParser> cachedParser = new HashMap<>();
    static {
        cachedParser.put("json",new JsonRuleConfigParser());
        cachedParser.put("xml",new XmlRuleConfigParser());
        cachedParser.put("yaml",new YamlRuleConfigParser());
        cachedParser.put("properties",new PropertiesRuleConfigParser());
    }
    public static IRuleConfigParser createParser(String configFormat){
        if (configFormat==null || configFormat.isEmpty()){
            return null;//或者抛异常
        }
        IRuleConfigParser parser = cachedParser.get(configFormat.toLowerCase());
        return parser;
    }
}
