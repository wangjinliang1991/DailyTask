package com.ai.rule.datasource;

import com.ai.rule.RuleConfig;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/25
 * @Version:
 **/
public interface RuleConfigSource {
    RuleConfig load();
}
