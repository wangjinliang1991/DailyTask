package com.ai.rule;

import java.util.List;

/**
 * @Description: RuleConfig嵌套AppRuleConfig 和 ApiLimit
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class RuleConfig {
    private List<UniformRuleConfig> configs;
    public List<AppRuleConfig> getConfigs(){
        return configs;
    }
    
    public void setConfigs(List<AppRuleConfig> configs){
        this.configs = configs;
    }
    
    public static class AppRuleConfig{
        private String appId;
        private List<ApiLimit> limits;
        public AppRuleConfig(){}
        public AppRuleConfig(String appId,List<ApiLimit> limits){
            this.appId = appId;
            this.limits = limits;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public List<ApiLimit> getLimits() {
            return limits;
        }

        public void setLimits(List<ApiLimit> limits) {
            this.limits = limits;
        }
    }
}
