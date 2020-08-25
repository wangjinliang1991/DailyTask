package com.ai;

import java.util.List;

/**
 * @Description: 用来映射配置到内存,DarkRuleConfig嵌套DarkFeatureConfig
 * @Author: wangjl
 * @Date: 2020/8/25
 * @Version: 1.0
 **/
public class DarkRuleConfig {
    private List<DarkFeatureConfig> features;
    public List<DarkFeatureConfig> getFeatures(){
        return this.features;
    }
    
    public void setFeatures(List<DarkFeatureConfig> features){
        this.features = features;
    }
    
    public static class DarkFeatureConfig{
        private String key;
        private boolean enabled;
        private String rule;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }

        public boolean geEnabled() {
            return false;
        }
    }
}
