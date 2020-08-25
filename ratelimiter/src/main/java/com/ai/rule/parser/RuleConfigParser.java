package com.ai.rule.parser;

import com.ai.rule.RuleConfig;

import java.io.InputStream;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/25
 * @Version:
 **/
public interface RuleConfigParser {
    RuleConfig parse(String configText);
    RuleConfig parse(InputStream in);
}
