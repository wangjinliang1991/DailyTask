package com.ai.doc.singleton;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class UserController {
    private Logger logger = new Logger();
    
    public void login(String username,String password){
        //...省略业务逻辑代码...
        logger.log(username+" logined!");
    }
}
