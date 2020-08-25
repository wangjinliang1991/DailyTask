package com.ai.doc.factory.factory1;

import com.ai.doc.factory.simple3.IRuleConfigParserFactory;
import com.ai.doc.factory.simple3.JsonRuleConfigParserFactory;
import com.ai.doc.factory.simple3.PropertiesRuleConfigParserFactory;
import com.ai.doc.factory.simple3.XmlRuleConfigParserFactory;
import com.ai.doc.factory.simple3.YamlRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 工厂的工厂
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();
    
    static {
        cachedFactories.put("json",new JsonRuleConfigParserFactory());
        cachedFactories.put("xml",new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml",new YamlRuleConfigParserFactory());
        cachedFactories.put("properties",new PropertiesRuleConfigParserFactory());
    }
    
    public static IRuleConfigParserFactory getParserFactory(String type){
        if (type==null || type.isEmpty()){
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
    
    
    
    
    
    
    
    
    
}
