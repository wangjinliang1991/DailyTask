package com.ai;

import java.util.UUID;

/**
 * @Description: 幂等号生成类
 * @Author: wangjl
 * @Date: 2020/8/25
 * @Version: 1.0
 **/
public class IdempotenceIdGenerator {
    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
