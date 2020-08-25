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
    //comment-1: 如果要替换存储方式，是否很麻烦
    private JedisCluster jedisCluster;
    
    //comment-2: 如果幂等框架要跟业务系统复用jedisCluster连接呢
    //comment-3: 是否应该注释说明redisClusterAddress的格式，config是否可传递
    public Idempotence(String redisClusterAddress, GenericObjectPoolConfig config){
        //comment-4: 这段逻辑放到构造函数，不容易写单元测试
        String[] addressArray = redisClusterAddress.split(";");
        Set<HostAndPort> redisNodes = new HashSet<>();
        for (String address:addressArray){
            String[] hostAndPort = address.split(":");
            redisNodes.add(new HostAndPort(hostAndPort[0],Integer.valueOf(hostAndPort[1])));
        }
        this.jedisCluster = new JedisCluster(redisNodes, config);
    }
    
    //comment-5: generateId()是否更好点
    //comment-6: 根据接口隔离原则，这个函数和其他函数的使用场景完全不同
    public String genId(){
        return UUID.randomUUID().toString();
    }
    
    //comment-7: 返回值的意义是否应该注释说明下
    public boolean saveIfAbsent(String idempotenceId){
        Long success = jedisCluster.setnx(idempotenceId,"1");
        return success==1;
    }
    
    public void delete(String idempotenceId){
        jedisCluster.del(idempotenceId);
    }
}
