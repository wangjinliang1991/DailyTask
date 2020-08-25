package com.ai.doc.template.callback;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallback() {//回调对象
            @Override
            public void methodToCallback() {
                System.out.println("call back me.");
            }
        });
    }
}
