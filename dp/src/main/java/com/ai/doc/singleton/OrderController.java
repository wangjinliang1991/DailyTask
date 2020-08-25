package com.ai.doc.singleton;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class OrderController {
    private Logger logger = new Logger();
    
    public void create(OrderVo order){
        //...省略业务逻辑代码...
        logger.log("Created an order: "+order.toString());
    }
}
