package com.ai.day0629;

/**
 * @Description: 12. 整数转罗马数字
 * @Author: wangjl
 * @Date: 2020/7/10
 * @Version: 1.0
 **/
public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        // loop through each symbol, stop if num becomes 0
        for (int i=0; i<values.length && num >=0;i++){
            // repeat while the current symbol still fits into num
            while (values[i]<=num){
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
