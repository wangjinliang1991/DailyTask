package com.ai.doc.template.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public abstract class TestCase extends Assert implements Test {
    public void runBare() throws Throwable{
        Throwable exception = null;
        setUp();
        try{
            runTest();
        }catch (Throwable running){
            exception = running;
        }finally {
            try{
                tearDown();
            }catch (Throwable tearingDown){
                if (exception == null) exception = tearingDown;
            }
        }
        if (exception != null) throw exception;
    }
    
    protected void setUp() throws Exception{}
    
    protected void tearDown() throws Exception{}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
