package com.ai.array.leetcode.majority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 229.求众数II
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     * 229.求众数II
     * 给定一个大小为n的数组，找出其中所有出现超过 n/3 次的元素
     * 说明：要求算法的时间复杂度O(n)，空间复杂度O(1)
     * 
     * 示例1：
     *      输入：[3,2,3]
     *      输出：[3]
     * 
     * 示例2：
     *      输入：[1,1,1,3,3,2,2,2]
     *      输出：[1,2]
     *      
     * 思路：先排序，然后整个哈希表？key为nums[i],value为count，最后比较count*3和n比较
     */
    public List<Integer> majorityElement(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = countMap.get(nums[i]);
            if (count>0){
                count++;
                countMap.put(nums[i],count);
            }
        }
        List<Integer> majorityList = new ArrayList<>();
        //todo
        return null;
    }
}
