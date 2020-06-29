package com.ai.day0626;

/**
 * @Description: 回文数
 * @Author: wangjl
 * @Date: 2020/6/29
 * @Version: 1.0
 **/
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String palindromeString = x+"";
        int len = palindromeString.length();
        // 将字符串翻转
        String reverseStr = new StringBuilder(palindromeString).reverse().toString();
        return reverseStr.equals(palindromeString);
    }

    public static void main(String[] args) {
        int x = -101;
        boolean palindrome = new Solution().isPalindrome(x);
        System.out.println(palindrome);
    }
}
