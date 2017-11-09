package com.mrx.appfactory.uhome.util;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @Type RedisUtil.java
 * @Desc 
 * @author xuwen
 * @date 2017年11月8日 下午4:26:44
 * @version
 */
@Service
public class RedisUtil {
    Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    public final static Long EXPIRE_TIME = 7200l;

    /**
     * 〈一句话功能简述〉设置key
     * 〈功能详细描述〉
     *
     * @param key
     * @param value
     * @throws Exception 
     */
    public void set(String key, Object value) throws Exception {
        redisTemplate.opsForValue().set(key, value, EXPIRE_TIME, TimeUnit.SECONDS);
    }

    /**
    * 〈一句话功能简述〉获取值
    * 〈功能详细描述〉
    *
    * @param key
    * @return
     * @throws Exception 
    */
    public Object get(String key) throws Exception {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 〈一句话功能简述〉删除key
     * 〈功能详细描述〉
     *
     * @param key
     * @throws Exception 
     */
    public void delete(String key) throws Exception {
        redisTemplate.delete(key);
    }

    /**
     * 〈一句话功能简述〉设置超时
     * 〈功能详细描述〉
     *
     * @param key
     * @throws Exception
     */
    public boolean expire(String key) throws Exception {
        return redisTemplate.expire(key, EXPIRE_TIME, TimeUnit.SECONDS);
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
