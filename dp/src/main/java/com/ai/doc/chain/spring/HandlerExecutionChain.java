package com.ai.doc.chain.spring;


import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class HandlerExecutionChain {
    private final Object handler;
    private HandlerInterceptor[] interceptors;
    
    public void addInterceptor(HandlerInterceptor interceptor){
        initInterceptorList().add(interceptor);
    }
    boolean applyPreHandler(HttpServletRequest request, HttpServletResponse response){
        handlerInterceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)){
            for (int i=0;i<interceptors.length;i++){
                HandlerInterceptor interceptor = interceptors[i];
                if (!interceptor.preHandle(request,response,this.handler)){
                    triggerAfterCompletion(request,response,null);
                    return false;
                }
            }
        }
        return true;
    }
    
    void applyPostHandle(HttpServletRequest request,HttpServletResponse response){
        handlerInterceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)){
            for (int i=interceptors.length-1;i>=0;i--){
                HandlerInterceptor interceptor = interceptors[i];
                interceptor.postHandle(request,response,this.handler,mv);
            }
        }
    }
    
    void triggerAfterCompletion(HttpServletRequest request,HttpServletResponse response){
        HandlerInterceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)){
            for (int i=interceptors.length-1;i>=0;i--){
                HandlerInterceptor interceptor = interceptors[i];
                try{
                    interceptor.afterCompletion(request,response,this.handler,ex);
                }catch (Throwable ex2){
                    logger.error("HandlerInterceptor.afterCompletion throw exception",ex2);
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
