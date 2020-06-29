package com.ai.day0627;

/**
 * @Description: 10. 正则表达式匹配
 * @Author: wangjl
 * @Date: 2020/6/29
 * @Version: 1.0
 **/
public class Solution {
    public boolean isMatch(String s, String p) {
        //动态规划，太难了...
        int m = s.length();
        int n = p.length();
        
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i=0;i<=m;++i){
            for (int j=1;j<=n;++j){
                if (p.charAt(j-1)=='*'){
                    f[i][j] = f[i][j-2];
                    if (matches(s,p,i,j-1)){
                        f[i][j] = f[i][j] || f[i-1][j];
                    }
                }else{
                    if (matches(s,p,i,j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i==0){
            return false;
        }
        if (p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

}
