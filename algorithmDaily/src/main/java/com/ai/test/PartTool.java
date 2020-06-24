package com.ai.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/6/21
 * @Version: 1.0
 **/
public class PartTool {
    // 遍历Map,返回指定key值的Map对象,若没有,返回null
    public static Map getMapFromMap(Map map, String mapKey) throws Exception {
        Map ret = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Object obj = map.get(key);
            if (obj instanceof Map) {
                if (key.equals(mapKey)) {
                    ret = (Map) obj;
                    break;
                } else {
                    ret = getMapFromMap((Map) obj, mapKey);
                    if (MapUtil.isNotEmpty(ret)) {
                        break;
                    }
                }
            }
        }
        return ret;
    }

    public static String getValueFromMap(Map map, String key) throws Exception {

        return getValueFromMap(map, key, new String());
    }

    public static String getValueFromMap(Map map, String key, String def) throws Exception {
        if (map == null) {
            return def;
        }
        if (map.get(key) == null||"".equals(map.get(key))) {
            return def;
        }
        return map.get(key).toString();
    }
}
