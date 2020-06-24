package com.ai.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/6/13
 * @Version: 1.0
 **/
public class Test {
    /*public static void main(String[] args) throws Exception {
        String a = "GSCRM123GSCRM456";
        System.out.println(a.indexOf("GSCRM"));
        System.out.println(a.lastIndexOf("GSCRM") + "GSCRM".length());
        String b = a.substring(a.lastIndexOf("GSCRM") + "GSCRM".length());
        System.out.println(b);

        List subOrderList = new ArrayList();
        Map subOrder = new HashMap();
        Map subInfoMap = new HashMap();
        subInfoMap.put("NUMBER_OPR_TYPE","test");
        subOrder.put("SUB_SCRIBER_INFO",subInfoMap);
        subOrderList.add(subOrder);
        boolean test = new Test().checkNumberOprType(subOrderList, "test");
        System.out.println(test);
    }
    
    public boolean  checkNumberOprType(List subOrderList, String numberOprType) throws Exception{
        String dealFlag="0";//默认待处理
        for(int i=0;i<subOrderList.size();i++) {
            Map subOrder = (Map) subOrderList.get(i);
            Map subInfoMap = PartTool.getMapFromMap(subOrder, "SUB_SCRIBER_INFO");
            String optType = PartTool.getValueFromMap(subInfoMap, "NUMBER_OPR_TYPE", "");
            if(numberOprType.contains(optType)){
                return true;
            }
        }
        return false;
    }*/
    
/*    public boolean test(){
        for (int i = 0; i < 6; i++) {
            // 调用接口网关接口上发...
            if(true){
                //上发成功，记录历史表
                return true;
            }
        }
    }*/

    public static int getMap(){
        Map map=new HashMap();
        map.put("a","b");
        for(int i=0;i<5;i++){
          String ss=bb();
           if (ss.equals("3")){
               return i;
           }
        }
        return 8;
    }
    
    public static String  bb(){
        System.out.println("33");
        return "3";
    }
    
    public static void main(String[] args) {
        System.out.println(getMap());
    }
}
