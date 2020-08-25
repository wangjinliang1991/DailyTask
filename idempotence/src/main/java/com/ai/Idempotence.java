package com.ai;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/25
 * @Version: 1.0
 **/
public class Idempotence {
    private IdempotenceStorage storage;
    
    public Idempotence(IdempotenceStorage storage){
        this.storage = storage;
    }
   
    public String genId(){
        return UUID.randomUUID().toString();
    }
    
    //comment-7: 返回值的意义是否应该注释说明下
    public boolean saveIfAbsent(String idempotenceId){
        return storage.saveIfAbsent(idempotenceId);
    }
    
    public void delete(String idempotenceId){
        storage.delete(idempotenceId);
    }
}
