package com.ai.doc.factory.factory3;

import com.ai.doc.factory.IRuleConfigParser;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/13
 * @Version:
 **/
public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();
    ISystemConfigParser createSystemParser();
    //此处可扩展新的parser类型，如IBizConfigParser
}
