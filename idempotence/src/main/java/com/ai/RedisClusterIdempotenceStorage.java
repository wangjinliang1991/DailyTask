package com.ai;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/25
 * @Version: 1.0
 **/
public class RedisClusterIdempotenceStorage implements IdempotenceStorage {
    private JedisCluster jedisCluster;

    /**
     * Constructor
     * @param redisClusterAddress the format is 128.91.12.1:3455;128.91.12.2:3455;128.91.12.3:3455
     * @param config should not be null
     */
    public RedisClusterIdempotenceStorage(String redisClusterAddress, GenericObjectPoolConfig config){
        Set<HostAndPort> redisNodes = parseHostAndPorts(redisClusterAddress);
        this.jedisCluster = new JedisCluster(redisNodes, config);
    }
    
    public RedisClusterIdempotenceStorage(JedisCluster jedisCluster){
        this.jedisCluster = jedisCluster;
    }

    /**
     * save {@idempotenceId} into storage if it does not exist
     * @param idempotenceId the idempotence id
     * @return true if the {@idempotenceId} is saved, otherwise return false
     */
    @Override
    public boolean saveIfAbsent(String idempotenceId){
        Long success = jedisCluster.setnx(idempotenceId,"1");
        return success==1;
    }
    @Override
    public void delete(String idempotenceId){
        jedisCluster.del(idempotenceId);
    }
    
    @VisibleForTesting
    protected Set<HostAndPort> parseHostAndPorts(String redisClusterAddress){
        String[] addressArray = redisClusterAddress.split(";");
        Set<HostAndPort> redisNodes = new HashSet<>();
        for (String address:addressArray){
            String[] hostAndPort = address.split(":");
            redisNodes.add(new HostAndPort(hostAndPort[0],Integer.valueOf(hostAndPort[1])));
        }
        return redisNodes;
    }
}
