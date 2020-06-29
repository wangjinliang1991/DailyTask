package com.ai.day0625;

/**
 * @Description: 8. 字符串转换整数 (atoi)
 * @Author: wangjl
 * @Date: 2020/6/27
 * @Version: 1.0
 **/
public class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int index = 0;
        while(index<n && chars[index] == ' '){
            //去掉前导空格
            index++;
        }
        if (index==n){
            //去掉前导空格就到了末尾了
            return 0;
        }
        
        boolean negative = false;
        if (chars[index] == '-'){
            //负号
            negative = true;
            index++;
        }else if (chars[index]=='+'){
            //正号
            index++;
        }else if (!Character.isDigit(chars[index])){
            //其他负号
            return 0;
        }
        
        int ans=0;
        while(index<n && Character.isDigit(chars[index])){
            int digit = chars[index] - '0';
            if (ans>(Integer.MAX_VALUE-digit)/10){
                //本来应该是ans*10+digit>Integer.MAX_VALUE
                // 但是*10和+digit都可能越界，移到右边
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans = ans*10+digit;
            index++;
        }
        return negative?-ans:ans;
    }

    public static void main(String[] args) {
        String str = "42 is";
        int i = new Solution().myAtoi(str);
        System.out.println(i);
    }
}
