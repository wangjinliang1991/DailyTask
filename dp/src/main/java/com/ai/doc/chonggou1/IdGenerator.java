package com.ai.doc.chonggou1;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/2
 * @Version:
 **/
public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
