package com.ai.array.leetcode.threeSumMulti;

/**
 * @Description: 923.三数之和的多种可能  太难了...以后见多了再看这个题目
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     *  923.三数之和的多种可能
     *  给定一个整数数组nums，以及一个整数target作为目标值，返回满足j<k且nums[i]+nums[j]+nums[k]==target
     *  的元素i,j,k的数量
     *  由于结果会非常大，请返回 结果除以10^9+7的余数
     *  
     *  示例1：
     *      输入：nums=[1,1,2,2,3,3,4,4,5,5] target=8
     *      输出：20
     *      解释：按值枚举(1,2,5)出现8次；
     *                  (1,3,4)出现8次；
     *                  (2,2,4)出现2次
     *                  (2,3,3)出现2次
     *  
     *  示例2：
     *      输入：nums=[1,1,2,2,2,2] target=5
     *      输出：12
     *      解释：nums[i]=1 nums[j]=nums[k]=2 出现12次
     *          从[1,1]中选出一个1，有2种情况
     *          从[2,2,2,2]中选出两个2，有6种情况
     *          
     *  提示：
     *      1. 3<=nums.length <= 3000
     *      2. 0<=nums[i] <=100
     *      3. 0<=target <=300
     *  
     *  解法：和双指针做 两数之和 差不多
     *       假设有个有序数组，同时该数组中元素唯一，想知道有多少对i,j，满足i<j且A[i]+A[j]==target
     *       两数之和可以在线性时间解决，定义两个指针i,j，初始分别指向数组的头尾，i逐渐递增，j逐渐递减，
     *       找出所有满足A[i]+A[j]==target的组合
     *  
     *  方法1：三指针
     *      先将数组排序，遍历下标，对于每个i，设T=target-A[i]作为剩余要凑成的目标数，接着用双指针完成
     *      A[j]+A[k]==T的子任务
     *      考虑到有些元素重复的，要小心处理边界条件。特殊情况下，如target=8，数组为[2,2,2,2,3,3,4,4,4,5,5,5,6,6]
     *      这个数组就有大量的重复元素可组成target，下面分析这种情况如何处理
     *      只要A[j]+A[k]==T,就要算上这一对j,k的组合。该例子中，当A[j]==2,A[k]==6，有4*2=8种组合
     *      特殊情况下，如果A[j]==A[k]，如最后剩下的[4,4,4]这里有3对，一般情况，如果A[j]==A[k]
     *      ...太难了，没看懂
     *   
     *  方法2：变种的三数之和
     *      count[x]为A中x出现的次数，同时，让keys为数组A中所有元素只出现一次的有序数组，接着用三数之和
     *      的方法处理keys
     *      举例，如果A=[1,1,2,2,3,3,4,4,5,5],target=8,得到keys=[1,2,3,4,5]，当对keys做三数之和时，
     *      会遇到一些组合使得三数相加为target，如(x,y,z)=(1,2,5),(1,3,4),(2,2,4),(2,3,3)
     *      接着用count算每种组合有多少次
     *     
     */
    public int threeSumMulti(int[] A,int target){
        int MOD = 1_000_000_007;
        
        //initializing as long saves us the trouble of 
        //managing count[x]*count[y]*count[z] overflowing later
        long[] count = new long[101];
        int uniq = 0;
        for (int x:A){
            count[x]++;
            if (count[x]==1){
                uniq++;
            }
        }
        
        //去重的新数组
        int[] keys = new int[uniq];
        int t=0;
        // 数组里的元素的值0-100 假设[1,1,2,2,3]
        for (int i=0;i<=100;i++){
            if (count[i]>0){
                keys[t++] = i;
            }
        }
        
        long ans =0;
        //now, let's do a 3sum on "keys", for i<=j <=k
        // we will use count to add the correct contribution to ans
        for (int i=0;i<keys.length;i++){
            int x=keys[i];
            int T = target - x;
            int j = i, k=keys.length-1;
            while (j<=k){
                int y = keys[j], z=keys[k];
                if (y+z < T){
                    j++;
                }else if (y+z >T){
                    k--;
                }else {
                    // # x+y+z==T, now calc the size of the contribution
                    if (i<j && j<k){
                        ans += count[x]*count[y]*count[z];
                    }else if (i==j && j<k){
                        ans += count[x]*(count[x]-1)/2*count[z];
                    }else if (i<j && j==k){
                        ans += count[x]*count[y]*(count[y]-1)/2;
                    }else{
                        // i==j==k
                        ans+=count[x]*(count[x]-1)*(count[x]-2)/6;
                    }
                    
                    ans %=MOD;
                    j++;
                    k--;
                }
            }
        }
        return (int)ans;
    }
}
