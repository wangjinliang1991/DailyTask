package com.asiainfo.day0606;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author: wangjl
 * @Date: 2020/6/6
 * @Version: 1.0
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target){
        int[] indexes = new int[2];
        // 解法1，太过耗时
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++){
                if (nums[i]+nums[j]==target && i!=j){
                    indexes[0]=i;
                    indexes[1]=j;
                    break;
                }
            }
        }
        return indexes;*/
        Map<Integer, Integer> map = new HashMap(16);
        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return indexes;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target = 9;
        int[] ints = new Solution().twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
