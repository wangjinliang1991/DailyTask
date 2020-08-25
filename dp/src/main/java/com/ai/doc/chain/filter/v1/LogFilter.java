package com.ai.doc.chain.filter.v1;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //创建filter时自动调用
        //其中filterConfig包含这个filter的配置参数，如name之类
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截客户端发来的请求");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截发送给客户端的请求");
    }

    @Override
    public void destroy() {
        //销毁filter时自动调用
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
