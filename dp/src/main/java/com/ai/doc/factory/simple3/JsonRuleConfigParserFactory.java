package com.ai.doc.factory.simple3;

import com.ai.doc.factory.IRuleConfigParser;
import com.ai.doc.factory.simple2.JsonRuleConfigParser;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
