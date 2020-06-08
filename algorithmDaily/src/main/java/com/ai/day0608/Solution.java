package com.ai.day0608;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 无重复字符的最长子串
 * @Author: wangjl
 * @Date: 2020/6/7
 * @Version: 1.0
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s){
       /* //第一种思路失败
       // 存入hashMap中
        Map<String, Integer> mappings = new HashMap<>(32);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (mappings.get(String.valueOf(aChar))==null){
                mappings.put(String.valueOf(aChar),1);
            }else{
                mappings.put(String.valueOf(aChar),mappings.get(String.valueOf(aChar))+1);
            }
        }
        // 比较
        int size = mappings.keySet().size();
        if (size==s.length() || size==1){
            // 全部都是不重复的或者只有1组
            return size;
        }else{
            // 个数大于1个的组中，最小个数的组
            String minChar="";
            mappings.put(minChar,2);
            for (String s1 : mappings.keySet()) {
                if (mappings.get(s1)>1){
                    if (mappings.get(minChar)>=mappings.get(s1)){
                        minChar = s1;
                    }
                }
            }
            // 之后再看该str的不连续的距离，反例abcddefg，并不能解决
            Integer sumMinChar = mappings.get(minChar);

        }*/

       // 第二种，滑动窗口
        if(s.length()==0){
            return 0;
        }
        // hashMap去重
        Map<Character, Integer> map = new HashMap<>(32);
        // 最大长度
        int maxLength = 0;
        // 滑动窗口的左边界
        int leftOfWindow = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                // 左边界是否右移
                leftOfWindow = Math.max(leftOfWindow,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            // 窗口宽度和原始最大长度比较
            maxLength = Math.max(maxLength,i-leftOfWindow+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // 常见
        System.out.println(new Solution().lengthOfLongestSubstring("abccdef"));
        // 字符串均为重复字符
        System.out.println(new Solution().lengthOfLongestSubstring("bbb"));
        // 字符串为空
        System.out.println(new Solution().lengthOfLongestSubstring(""));
    }
}
