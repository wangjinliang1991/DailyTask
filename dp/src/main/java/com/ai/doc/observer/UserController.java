package com.ai.doc.observer;

import com.ai.doc.observer.v2.UserService;
import com.ai.doc.observer.v3.RegObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class UserController {
    private UserService userService;//依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;
    public UserController(Executor executor){
        this.executor = executor;
    }
    public void setRegObservers(List<RegObserver> observers){
        regObservers.addAll(observers);
    }
    public Long register(String telephone,String password){
        //省略输入的校验代码
        //省略userService.register()异常的try-catch代码
        final long userId = userService.register(telephone,password);
        for (final RegObserver observer: regObservers){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observer.handleRegSuccess(userId);
                }
            });
        }
        return userId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
