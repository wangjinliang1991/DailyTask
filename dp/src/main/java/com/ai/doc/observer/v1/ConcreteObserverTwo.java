package com.ai.doc.observer.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        //todo 获取消息通知，执行自己的逻辑
        System.out.println("ConcreteObserverTwo is notified");
    }
}
