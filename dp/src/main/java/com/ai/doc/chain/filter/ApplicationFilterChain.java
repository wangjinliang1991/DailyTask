package com.ai.doc.chain.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class ApplicationFilterChain implements FilterChain {
    private int pos = 0;//当前执行到哪个filter
    private int n;//filter的个数
    private ApplicationFilterConfig[] filters;
    private Servlet servlet;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (pos < n){
            ApplicationFilterConfig filterConfig = filters[pos++];
            Filter filter = filterConfig.getFilter();
            filter.doFilter(request,response,this);
        }else {
            //filter都处理完毕，执行servlet
            servlet.service(request, response);
        }
    }
    
    public void addFilter(ApplicationFilterConfig filterConfig){
        for (ApplicationFilterConfig filter:filters){
            if (filter == filterConfig){
                return;
            }
        }
        if (n==filters.length){
            //扩容
            ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n+n];
            System.arraycopy(filters,0,newFilters,0,n);
            filters = newFilters;
        }
        filters[n++] = filterConfig;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
