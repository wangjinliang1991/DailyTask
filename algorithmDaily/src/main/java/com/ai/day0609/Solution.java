package com.ai.day0609;

/**
 * @Description: 寻找两个正序数组的中位数
 * @Author: wangjl
 * @Date: 2020/6/9
 * @Version: 1.0
 **/
public class Solution {

    /**
     * 解法1，暴力法，时间复杂度为m+n，空间复杂度，新数组m+n
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sumNums = new int[nums1.length + nums2.length];
        // 存入sumNums中

//        return sumNums.length%2==0? (sumNums[sumNums.length/2]+sumNums[sumNums.length/2+1])/2:sumNums[sumNums.length/2]/2;

        int m = nums1.length;
        int n = nums2.length;
        // nums1为空
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2 + 1]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        // nums2为空
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2 + 1]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        // 正常情况
        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    sumNums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    sumNums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                sumNums[count++] = nums1[i++];
            } else {
                sumNums[count++] = nums2[j++];
            }
        }

        // 得出sumNums的count
        if (count % 2 == 0) {
            return (sumNums[count / 2] + sumNums[count / 2 + 1]) / 2.0;
        } else {
            return sumNums[count / 2];
        }
    }

    /**
     * 解法2 二分查找，时间复杂度有log，一般都是二分查找
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            // 转换，保证nums1的长度小于nums2
            int[] temp = nums1;
            nums1=nums2;
            nums2 = temp;
        }

        // m小于n
        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数m+(n-m+1)/2
        int totalLeft = (m+n+1)/2;

        // 在nums1的区间[0,m]里查找恰当的分割线
        // 使得nums1[i-1]<=nums2[j] && nums2[j-1]<=nums1[i]
        int left = 0;
        int right = m;
        while(left<right){
            int i = left + (right-left+1)/2;
            int j = totalLeft-i;
            if (nums1[i-1]>nums2[j]){
                // 下一轮搜索区间为[left,i-1]
                right = i -1;
            }else {
                // 下一轮搜索区间[i,right]
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin = i == m?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax = j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin = j==n?Integer.MAX_VALUE:nums2[j];

        if ((m+n)%2==1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else{
            return (double)(Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMin,nums2RightMin))/2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};

        int[] nums2 = new int[]{3,4,5};
        int[] nums3 = new int[]{};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums3));
    }
}
