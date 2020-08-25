package com.ai.doc.singleton.multiton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class BackendServer {
    private long serverNo;
    private String serverAddress;
    private static final int SERVER_COUNT = 3;
    private static final Map<Long,BackendServer> serverInstances = new HashMap<>();
    
    static {
        serverInstances.put(1L,new BackendServer(1L,"192.134.11.111:8080"));
        serverInstances.put(2L,new BackendServer(2L,"192.134.11.112:8080"));
        serverInstances.put(3L,new BackendServer(3L,"192.134.11.113:8080"));
    }
    private BackendServer(long serverNo,String serverAddress){
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }
    public BackendServer getInstance(long serverNo){
        return serverInstances.get(serverNo);
    }
    public BackendServer getRandomInstance(){
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT)+1;
        return serverInstances.get(no);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
