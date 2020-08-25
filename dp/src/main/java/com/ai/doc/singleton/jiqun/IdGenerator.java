package com.ai.doc.singleton.jiqun;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: 集群的单例
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;
    private static SharedObjectStorage storage = FileSharedObjectStorage();
    private static DistributedLock lock = new DistributedLock();
    
    private IdGenerator(){}
    public synchronized static IdGenerator getInstance(){
        if (instance == null){
            lock.lock();
            instance = storage.load(IdGenerator.class);
        }
        return instance;
    }
    
    public synchronized void freeInstance(){
        storage.save(this,IdGenerator.class);
        instance = null;//释放对象
        lock.unlock();
    }
    
    public long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
