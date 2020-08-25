package com.ai.doc.template.servlet;

import org.springframework.http.server.ServerHttpResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.MessageFormat;

import static org.springframework.web.servlet.support.WebContentGenerator.METHOD_GET;
import static org.springframework.web.servlet.support.WebContentGenerator.METHOD_HEAD;
import static org.springframework.web.servlet.support.WebContentGenerator.METHOD_POST;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public class HttpServlet {
    public void service(ServletRequest req, ServerHttpResponse res) throws Exception{
        HttpServletRequest request;
        HttpServletResponse response;
        if (!(req instanceof HttpServletRequest && res instanceof HttpServletResponse)){
            throw new ServletException("non-HTTP request or response");
        }
        request = (HttpServletRequest)req;
        response = (HttpServletResponse)res;
        service(request,response);
    }
    protected void service(HttpServletRequest req,HttpServletResponse resp)throws Exception{
        String method = req.getMethod();
        if (method.equals(METHOD_GET)){
            long lastModified = getLastModified(req);
            if (lastModified == -1){
                //servlet doesn't support if-modified-since, no reason
                // to go through further expensive login 
                doGet(req,resp);
            }else{
                long ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
                if (ifModifiedSince < lastModified){
                    // if the servlet mod time is later,call doGet()
                    //round down to the nearest second for a proper compare
                    // a ifModifiedSince of -1 will always be less
                    maybeSetLastModified(resp,lastModified);
                    doGet(req,resp);
                }else {
                    resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                }
            }
        }else if (method.equals(METHOD_HEAD)){
            long lastModified = getLastModified(req);
            maybeSetLastModified(resp,lastModified);
            doHead(req,resp);
        }else if (method.equals(METHOD_POST)){
            doPost(req,resp);
        }else if (method.equals(METHOD_PUT)){
            doPut(req,resp);
        }else if (method.equals(METHOD_DELETE)){
            doDelete(req,resp);
        }else if (method.equals(METHOD_OPTIONS)){
            doOptions(req,resp);
        }else if (method.equals(METHOD_TRACE)){
            doTrace(req,resp);
        }else {
            String errMsg = lString.getString("http.method_not_implemented");
            Object[] errArgs = new Object[1];
            errArgs[0] = method;
            errMsg = MessageFormat.format(errMsg,errArgs);
            resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED,errMsg;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
