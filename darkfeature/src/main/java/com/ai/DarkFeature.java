package com.ai;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 每个feature的灰度规则
 * @Author: wangjl
 * @Date: 2020/8/25
 * @Version: 1.0
 **/
public class DarkFeature {
    private String key;
    private boolean enabled;
    private int percentage;
    private RangeSet<Long> rangeSet = TreeRangeSet.create();
    
    public DarkFeature(DarkRuleConfig.DarkFeatureConfig darkFeatureConfig){
        this.key = darkFeatureConfig.getKey();
        this.enabled = darkFeatureConfig.geEnabled();
        String darkRule = darkFeatureConfig.getRule().trim();
        parseDarkRule(darkRule);
    }
    
    @VisibleForTesting
    protected void parseDarkRule(String darkRule){
        if (!darkRule.startsWith("{") || !darkRule.endsWith("}")){
            throw new RuntimeException("failed to parse dark rule: "+darkRule);
        }
        String[] rules = darkRule.substring(1,darkRule.length()-1).split(",");
        this.rangeSet.clear();
        this.percentage = 0;
        for (String rule:rules){
            rule = rule.trim();
            if (StringUtils.isEmpty(rule)){
                continue;
            }
        }
        if (darkRule.startsWith("%")){
            int newPercentage = Integer.parseInt(darkRule.substring(1));
            if (newPercentage > this.percentage){
                this.percentage = newPercentage;
            }
        }else if(darkRule.contains("-")){
            String[] parts = darkRule.split("-");
            if(parts.length != 2){
                throw new RuntimeException("failed to parse dark rule: "+darkRule);
            }
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            if (start > end){
                throw new RuntimeException("failed to parse dark rule: "+darkRule);
            }
            this.rangeSet.add(Range.closed(start,end));
        }else{
            long val = Long.parseLong(darkRule);
            this.rangeSet.add(Range.closed(val,val));
        }
    }
    
    public boolean enabled(){
        return this.enabled;
    }
    public boolean dark(long darkTarget){
        boolean selected = this.rangeSet.contains(darkTarget);
        if (selected){
            return true;
        }
        long reminder = darkTarget % 100;
        if (reminder >= 0 && reminder < this.percentage){
            return true;
        }
        return false;
    }
    
    public boolean dark(String darkTarget){
        long target = Long.parseLong(darkTarget);
        return dark(target);
    }
}
