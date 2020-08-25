package com.ai.alg;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 限流类算法实现类，实现最简单的固定时间窗口限流算法
 * @Author: wangjl
 * @Date: 2020/8/24
 * @Version: 1.0
 **/
public class RateLimitAlg {
    // timeout for {@code Lock.tryLock()}
    private static final long TRY_LOCK_TIMEOUT = 200L;//200ms
    private Stopwatch stopWatch;
    private AtomicInteger currentCount = new AtomicInteger(0);
    private final int limit;
    private Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this(limit, Stopwatch.createStarted());
    }
    
    @VisibleForTesting
    protected RateLimitAlg(int limit, Stopwatch stopwatch){
        this.limit = limit;
        this.stopWatch = stopwatch;
    }
    public boolean tryAcquire() throws InternalError{
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit){
            return true;
        }
        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)){
                try {
                    if (stopWatch.elapsed(TimeUnit.MILLISECONDS)>TimeUnit.SECONDS.toMillis()){
                        currentCount.set(0);
                        stopWatch.reset();
                    }
                    updatedCount = currentCount.incrementAndGet();
                    return updatedCount <= limit;
                }finally {
                    lock.unlock();
                }
            }else {
                throw new InternalError("tryAcquire() wait lock too long:"+updatedCount);
            }
        }catch (InternalError e){
            throw new InternalError("tryAcquire() is interrupted by lock-time");
        }
    }
}
