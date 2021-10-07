package com.example.crm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
    public String get(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }
}
