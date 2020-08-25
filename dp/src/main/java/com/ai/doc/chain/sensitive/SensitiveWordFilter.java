package com.ai.doc.chain.sensitive;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
