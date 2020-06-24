package com.ai.test;

import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/6/21
 * @Version: 1.0
 **/
public class MapUtil {
    public static boolean isEmpty(Map map){
        if(map == null || map.size() <= 0){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Map map){
        return !isEmpty(map);
    }
}
