package com.ai.day0628;

/**
 * @Description: 11. 盛最多水的容器
 * @Author: wangjl
 * @Date: 2020/6/29
 * @Version: 1.0
 **/
public class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length - 1;
        int res = 0;
        while (i<j){
            res = height[i] < height[j] ?
                    Math.max(res,(j-i)*height[i]):
                    Math.max(res,(j-i)*height[j]);
        }
        return res;
    }
}
