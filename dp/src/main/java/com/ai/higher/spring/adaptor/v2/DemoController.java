package com.ai.higher.spring.adaptor.v2;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class DemoController implements Controller {
    //方法二：实现Controller接口+xml配置文件：配置DemoController和URL的对应关系
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("Greeting");
        modelAndView.addObject("message","dinish madhwal");
        return modelAndView;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
