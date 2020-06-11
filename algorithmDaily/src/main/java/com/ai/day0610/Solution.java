package com.ai.day0610;

/**
 * @Description: 最长回文子串
 * @Author: wangjl
 * @Date: 2020/6/11
 * @Version: 1.0
 **/
public class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i=0;i<len;i++){
            for (int j=i+1;j<=len;j++){
                String test = s.substring(i,j);
                // 和回文长度比，选出最长
                if (isPalindrome(test) && test.length()>max){
                    ans = s.substring(i,j);
                    max = Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    /**
     * 是否是回文
     * @param s
     * @return
     */
    private boolean isPalindrome(String s){
        int len = s.length();
        for (int i=0;i<len/2;i++){
            // len-i-1 长度其实从0开始算，len为+1
            if (s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 解法2：动态规划
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if(s.equals("")){
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if (origin.charAt(i)==reverse.charAt(j)){
                    if (i==0 || j==0){
                        arr[i][j]=1;
                    }else{
                        arr[i][j]=arr[i-1][j-1]+1;
                    }
                }
                if (arr[i][j]>maxLen){
                    maxLen = arr[i][j];
                    // 以i位置结尾的字符
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd-maxLen+1,maxEnd+1);
    }

    public static void main(String[] args) {
        String abcdc = new Solution().longestPalindrome("abcdc");
        System.out.println(abcdc);
    }
}
