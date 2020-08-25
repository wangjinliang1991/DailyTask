package com.ai.doc.observer.v2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class UserController {
    private UserService userService;//依赖注入
    private PromotionService promotionService;//依赖注入
    public Long register(String telephone, String password){
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone,password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
