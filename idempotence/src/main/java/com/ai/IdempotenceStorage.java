package com.ai;

/**
 * @Description: 用来读写幂等号
 * @Author:
 * @Date: 2020/8/25
 * @Version:
 **/
public interface IdempotenceStorage {
    boolean saveIfAbsent(String idempotenceId);
    void delete(String idempotenceId);
}
