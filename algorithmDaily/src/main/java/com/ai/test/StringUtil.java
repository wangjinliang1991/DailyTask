package com.ai.test;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/7/7
 * @Version: 1.0
 **/
public class StringUtil {
    
    private final static String[] EMPTY_ARRAY = new String[0];
    public static final String DEFAULT_SEPARATOR = ",";
    public static final String EMPTY = "";
    private static final int PAD_LIMIT = 8192;

    /**
     * 空白，" "不属于空白
     * @param value
     * @return
     */
    public static boolean isEmpty(String value){
        return value==null || value.length() == 0;
    }

    /**
     * 空白，包含空格符组成的字符，如"  "
     * @param value
     * @return
     */
    public static boolean isBlank(String value){
        return value==null || value.trim().length() == 0;//精彩，trim删掉空格符
    }

    /**
     * 数组转换为字符串，分隔符为split
     * @param arr
     * @param split
     * @return
     */
    public static String join(String[] arr,String split){
        if (null==arr || arr.length==0){
            System.out.println("准备处理的字符串数组为空或者长度为0");
            return null;
        }
        
        if (null == split || split.isEmpty()){
            System.out.println("分隔符为空");
            return null;
        }
        
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            sb.append(split).append(str);
        }
        return sb.substring(1);//厉害，这样刚好把第一个字符给删掉了
    }
    
    

    public static void main(String[] args) {
        String[] arr = new String[]{"a","b","c"};
        String join = join(arr, ":");
        System.out.println(join);
    }
}
