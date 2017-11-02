package com.mrx.appfactory.common.util;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * @author xuwen
 *
 */
public class RedisLock {

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Lock key path.
     */
    private String lockKey;

    private boolean locked = false;

    /**
     */
    public RedisLock(RedisTemplate<String, Object> redisTemplate, String lockKey) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey + "_lock";
    }

    /**
     * @return lock key
     */
    public String getLockKey() {
        return lockKey;
    }

    /**
     * 获得 lock
     */
    public boolean lock() {
        try {
            if (redisTemplate.opsForValue().setIfAbsent(lockKey, "")) {
                locked = true;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 释放 lock release.
     */
    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }

}

