package com.ai.day0701;

import java.util.Arrays;

/**
 * @Description: 14. 最长公共前缀
 * @Author: wangjl
 * @Date: 2020/7/12
 * @Version: 1.0
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0){
            return "";
        }
        // 先按照字典排序
        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);
        char[] firstChar = strs[0].toCharArray();
        char[] lastChar = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < firstChar.length; i++) {
            if (firstChar[i]==lastChar[i] && i<lastChar.length){
                prefix.append(firstChar[i]);
            }else{
                break;
            }
        }
        return prefix.toString();
    }
}
