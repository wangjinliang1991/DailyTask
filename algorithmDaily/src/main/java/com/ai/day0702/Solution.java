package com.ai.day0702;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 三数之和
 * @Author: wangjl
 * @Date: 2020/7/12
 * @Version: 1.0
 **/
public class Solution {
    /**
     * 失败，一直为空，很奇怪
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int firstNum , secondNum, lastNum;
        List<Integer> aList = new ArrayList<>();
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i <= nums.length-3; i++) {
            firstNum = nums[i];
            List<List<Integer>> allList1 = new ArrayList<>();
            for(int j=i+1;j<=nums.length-2;j++){
                secondNum = nums[j];
                lastNum = -firstNum-secondNum;
                // 之后的数组是否包含这个int
                boolean flag = false;
                for (int r=j+1;r<= nums.length-1;r++){
                    if (nums[r]==lastNum){
                        flag=true;
                        break;
                    }
                }
                if (flag){
                    // allList为什么会归零? 
                    aList.add(firstNum);
                    aList.add(secondNum);
                    aList.add(lastNum);
                    allList1.add(aList);
                    aList.clear();
                }
            }
            allList.addAll(allList1);
        }
        return allList;
    }

    public static void main(String[] args) {
        int[] Nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum3(Nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum2(int[] nums){
        if (nums==null || nums.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
       
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return allList;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int leftCursor = i+1;
            int rightCursor = nums.length-1;
            while (leftCursor<rightCursor){
                if (nums[i]+nums[leftCursor]+nums[rightCursor]==0){
                    List<Integer> aList = new ArrayList<>();
                    aList.add(nums[i]);
                    aList.add(nums[leftCursor]);
                    aList.add(nums[rightCursor]);
                    allList.add(aList);
                    while (leftCursor<rightCursor && nums[leftCursor]==nums[leftCursor+1]){
                        leftCursor+=1;
                    }
                    while (leftCursor<rightCursor && nums[rightCursor]==nums[rightCursor-1]){
                        rightCursor-=1;
                    }
                }else if (nums[i]+nums[leftCursor]+nums[rightCursor]>0){
                    rightCursor-=1;
                }else{
                    leftCursor+=1;
                }
            }
        }
        return allList;
    }

    public List<List<Integer>> threeSum3(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
}
