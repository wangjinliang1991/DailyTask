package com.ai.day0624;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/6/24
 * @Version: 1.0
 **/
public class Solution {
    public int reverse(int x) {
        int reversNum = 0;
        // 绝对值
        int abs = Math.abs(x);
        String absStr = abs+"";
        String absStrReverse = new StringBuffer(absStr).reverse().toString();
        // 转int
        int parseInt = Integer.parseInt(absStrReverse);
        if (x>=0){
            reversNum = parseInt;
        }else{
            reversNum = -parseInt;
        }
        if (reversNum>Math.pow(2,31)-1 || reversNum <Math.pow(-2,31) ){
            reversNum=0;
        }

        return reversNum;
    }

    public static void main(String[] args) {
        int a = -120;
        int reverse = new Solution().reverse(a);
        System.out.println(reverse);
    }
}
