package com.ai.day0624;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/6/24
 * @Version: 1.0
 **/
public class Solution {
    /**
     * 常见想法，会报错，难处理异常情况
     * @param x
     * @return
     */
    public int reverse(int x) {
        int reversNum = 0;
        // 绝对值
        int abs = Math.abs(x);
        String absStr = abs+"";
        if (abs>=1534236469){
            return 0;
        }
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
    
    public int reverse2(int x){
        int rev = 0;
        while (x!=0){
            // 取模，也就是余数
            int pop = x%10;
            x = x/10;
            if (rev >Integer.MAX_VALUE /10 || (rev==Integer.MAX_VALUE/10 && pop >Integer.MAX_VALUE%10)){
                rev=0;
                break;
            }else if (rev <Integer.MIN_VALUE /10 || (rev ==Integer.MIN_VALUE/10 && pop <Integer.MIN_VALUE%10)){
                rev=0;
                break;
            }
            rev = rev*10+pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int a = 1534236469;
        int reverse = new Solution().reverse(a);
        System.out.println(reverse);
    }
}
