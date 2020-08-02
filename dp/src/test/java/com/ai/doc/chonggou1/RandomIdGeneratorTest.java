package com.ai.doc.chonggou1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class RandomIdGeneratorTest {
    @Test
    public void testGetLastSubstrSplittedByDot(){
        RandomIdGenrator idGenrator = new RandomIdGenrator();
        String actualSubstr = idGenrator.getLastSubstrSplittedByDot("field1.field2.field3");
        Assert.assertEquals("field3",actualSubstr);
        
        actualSubstr = idGenrator.getLastSubstrSplittedByDot("field1");
        Assert.assertEquals("field1",actualSubstr);
        
        actualSubstr = idGenrator.getLastSubstrSplittedByDot("field1#field2#field3");
        Assert.assertEquals("field1#field2#field3",actualSubstr);
    }

    //此单元测试会失败，因为在代码中没有处理hostName为null或空字符串的情况
    //之后优化
    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty(){
        RandomIdGenrator idGenrator = new RandomIdGenrator();
        String actualSubstr = idGenrator.getLastSubstrSplittedByDot(null);
        Assert.assertNull(actualSubstr);

        actualSubstr = idGenrator.getLastSubstrSplittedByDot("");
        Assert.assertEquals("",actualSubstr);
    }
    
    @Test
    public void testGenerateRandomAlphameric(){
        RandomIdGenrator idGenrator = new RandomIdGenrator();
        String actualRandomString = idGenrator.generateRandomAlphameric(6);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(6,actualRandomString.length());
        for (char c: actualRandomString.toCharArray()){
            Assert.assertTrue(('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'));
        }
    }

    //此单元测试会失败，因为在代码中没有处理length<=0的情况
    //之后优化
    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero(){
        RandomIdGenrator idGenrator = new RandomIdGenrator();
        String actualRandomString = idGenrator.generateRandomAlphameric(0);
        Assert.assertEquals("",actualRandomString);
        
        actualRandomString = idGenrator.generateRandomAlphameric(-1);
        Assert.assertNull(actualRandomString);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
