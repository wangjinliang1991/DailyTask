package com.ai.doc.observer.v3;

import com.ai.doc.observer.v2.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class UserController {
    private UserService userService;
    private List<RegObserver> regObservers = new ArrayList<>();
    //一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers){
        regObservers.addAll(observers);
    }
    
    public Long register(String telephone,String password){
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone,password);
        for (RegObserver observer:regObservers){
            observer.handleRegSuccess(userId);
        }
        return userId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
