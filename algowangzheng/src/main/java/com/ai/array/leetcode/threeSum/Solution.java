package com.ai.array.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15.三数之和
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     *  15.三数之和
     *  给你一个包含n个证书的数组nums，判断nums中是否存在三个元素a,b,c，使得a+b+c=0?
     *  请你找出所有满足条件且不重复的三元组
     *  注意：答案中不可以包含重复的三元组
     *  
     *  示例：
     *      给定数组 nums=[-1,0,1,2,-1,-4]
     *      满足要求的三元组集合为：
     *      [
     *          [-1,0,1],
     *          [-1,-1,2]
     *      ]
     *      
     *  解法1：排序+双指针
     *      先排序，由小到大，[-4,-1,-1,0,1,2]
     *      其实是a,b,c三重循环，需要保证b循环的元素不小于a,c循环的元素不小于b，也就是a<=b<=c
     *      因此，先排序，之后考虑假设第一个三元组b为-1，那下一个三元组的b就不能重复，应跳过-1 
     *      伪代码如下：
     *          nums.sort()
     *          for first=0...n-1
     *              //只有和上一次枚举的元素不相同，才会进行枚举
     *              if first==0 or nums[first]!=nums[first-1] then
     *                  for second=first+1...n-1
     *                      if  second==first+1 or nums[second]!=nums[second-1] then
     *                          for third=second+1...n-1
     *                              if third=second+1 or nums[third]!=nums[third-1] then
     *                                  //判断是否有a+b+c==0
     *                                  check(first,second,third)
     *  
     *      可以继续优化，如果固定了a和b，那么只有唯一的c满足a+b+c=0，当第二重循环往后枚举一个元素b'时，由于b'>b
     *      那么满足a+b'+c'=0的c'一定有c'<c，也就是c'在数组中一定出现在c的左侧，也就是说，可以从小到大枚举b，同时
     *      从大到小枚举c，即**第二重循环和第三重循环实际上并列**
     *      这样，可保持第二重循环不变，第三重循环变成从数组最右端开始向左移动的指针，伪代码：
     *          nums.sort()
     *          for first=0...n-1
     *              if first==0 or nums[first]!=nums[first-1] then
     *                  //第三重循环对应的指针
     *                  third=n-1
     *                  for second=first+1...n-1
     *                      if second==first+1 or nums[second]!=nums[second-1] then
     *                          //向左移动指针，直到a+b+c不大于0
     *                          while nums[first]+nums[second]+nums[third]>0
     *                              third = third-1
     *                          //判断是否有a+b+c==0
     *                          check(first,second,third)
     *      这就是常说的双指针，当需要枚举数组中的两个元素，如果随着第一个元素的递增，第二个元素时递减，就可使用双指针，
     *      将枚举的时间复杂度从O(N²)减少到O(N)
     */
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //枚举a
        for (int first=0;first<n;first++){
            //需要和上一次枚举的数不相同
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            //c对应的指针初始指向数组的最右端
            int third = n-1;
            int target = -nums[first];
            // 枚举b
            for (int second=first+1;second<n;second++){
                //需要和上一次枚举的数不相同
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                //需要保证b的指针在c的指针的左侧
                while (second<third && nums[second]+nums[third]>target){
                    third--;
                }
                //如果指针重合，随着b后续的增加就不会有满足a+b+c=0且b<c的c,退出循环
                if (second==third){
                    break;
                }
                if (nums[second]+nums[third]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //nums=[-1,0,1,2,-1,-4]
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = new Solution().threeSum(nums);
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> integers = ans.get(i);
            System.out.println(integers.toString());
        }
    }
}
