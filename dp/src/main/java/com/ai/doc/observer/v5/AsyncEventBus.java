package com.ai.doc.observer.v5;

import java.util.concurrent.Executor;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor){
        super(executor);
    }
}
