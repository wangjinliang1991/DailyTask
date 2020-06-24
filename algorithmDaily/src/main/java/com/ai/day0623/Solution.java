package com.ai.day0623;

/**
 * @Description: zigzag
 * @Author: wangjl
 * @Date: 2020/6/23
 * @Version: 1.0
 **/
public class Solution {
    public String convert(String s, int numRows) {
        // numRows为1时，不需要zigzag变换
        if (s==null || s.length() == 0 || numRows<=1){
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < array.length; i++) {
            array[i] = new StringBuilder();
        }
        
        int dir = 1;
        int index = 0;

        for (char c : s.toCharArray()) {
            array[index].append(c);
            // dir推动往哪个SB中塞char
            index += dir;
            if (index == 0 || index == numRows-1){
                // 如果在首尾两端，dir要转向，推动SB的转向
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String convert = new Solution().convert(s, numRows);
        System.out.println(convert);
    }
}
