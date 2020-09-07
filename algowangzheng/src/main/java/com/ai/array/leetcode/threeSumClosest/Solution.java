package com.ai.array.leetcode.threeSumClosest;

import com.ai.array.Array;

import java.util.Arrays;

/**
 * @Description: 16.最接近的三数之和
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     *  16.最接近的三数之和
     *  给定一个包括n个整数的数组nums和一个目标值target，找到nums中的三个整数，使得
     *  它们的和与target最接近，返回这三个数的和，假定每组输入只存在唯一答案
     *  
     *  示例：
     *      输入：nums=[-1,2,1,-4], target=1
     *      输出：2
     *      解释：与target最接近的和是 2 （-1+2+1=2）
     *  提示：
     *      1. 3<=nums.length<=10³
     *      2. -10³ <= nums[i] <= 10³
     *      3. -10^4 <=target <= 10^4
     *      
     *  思路：先排序 [-4,-1,1,2]，和三数之和一样，去重，比较跟target的绝对值差值
     *  
     *  解法：排序+双指针
     *      最接近就是差值的绝对值最小，还是用三重循环枚举三元组
     *      首先考虑第一个元素a，剩下两个元素b和c，希望他们的和最接近target-a
     *      借助双指针，优化枚举过程，second和third分别表示b和c的指针，初始，a位于i，second指向
     *      i+1，即左边界;third指向n-1，即右边界，每一步枚举过程，用a+b+c更新答案，且
     *          - 如果a+b+c>=target，可将third左移一个位置
     *          - 如果a+b+c<target，将second右移一个位置
     *      为什么？对a+b+c>=target的情况分析：如果a+b+c>=target,且second到third中的所有数升序，
     *          如果third不变，second右移，那么a+b+c会越来越大，远离最接近target的值，因此，固定third
     *          的情况下，初始的second就是最接近target的值，因此要固定second，左移third
     *     同样，a+b+c<target时，如果a+b+c<target，且second到third升序，如果second不变，third左移，
     *          a+b+c的值会越来越小，远离target，固定second，此时的third可得到最接近target的值，
     *          以后要固定third，second右移
     *          
     *     优化：如果枚举刚好等于target，直接返回即可
     */
    public int threeSumClosest(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;
        
        //枚举a
        for (int i=0; i<n; i++){
            //保证和上一次枚举的元素不相等
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //使用双指针枚举b和c
            int j=i+1,k=n-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==target){
                    return target;
                }
                //根据差值的绝对值更新答案
                if (Math.abs(sum-target) <Math.abs(best-target)){
                    best = sum;
                }
                if (sum>target){
                    //如果和大于target，移动c的指针
                    int k0 = k-1;
                    //移动到下一个不相等的元素
                    while (j<k0 && nums[k0]==nums[k]){
                        k0--;
                    }
                    k=k0;
                }else {
                    //如果和小于target，移动b对应的指针
                    int j0 = j+1;
                    //移动到下一个不相等的元素
                    while (j0<k && nums[j0]==nums[j]){
                        j0++;
                    }
                    j=j0;
                }
            }
        }
        return best;
    }
}
