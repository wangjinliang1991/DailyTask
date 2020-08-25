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
    private JedisCluster jedisCluster;
    public Idempotence(String redisClusterAddress, GenericObjectPoolConfig config){
        String[] addressArray = redisClusterAddress.split(";");
        Set<HostAndPort> redisNodes = new HashSet<>();
        for (String address:addressArray){
            String[] hostAndPort = address.split(":");
            redisNodes.add(new HostAndPort(hostAndPort[0],Integer.valueOf(hostAndPort[1])));
        }
        this.jedisCluster = new JedisCluster(redisNodes, config);
    }
    
    public String genId(){
        return UUID.randomUUID().toString();
    }
    
    public boolean saveIfAbsent(String idempotenceId){
        Long success = jedisCluster.setnx(idempotenceId,"1");
        return success==1;
    }
    
    public void delete(String idempotenceId){
        jedisCluster.del(idempotenceId);
    }
}
