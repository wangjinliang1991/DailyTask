package com.ai.higher.spring.adaptor.v1;

import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
@Controller
public class DemoController {
    @RequestMapping("/employname")
    public ModelAndView getEmployeeName(){
        ModelAndView modelAndView = new ModelAndView("Greeting");
        modelAndView.addObject("message","Dinesh");
        return modelAndView;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
