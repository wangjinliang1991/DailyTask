package com.ai.doc.factory.factory3;

import com.ai.doc.factory.IRuleConfigParser;
import com.ai.doc.factory.simple2.JsonRuleConfigParser;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/13
 * @Version: 1.0
 **/
public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
