package com.example.crm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public void set(String map,String key, Object value) {
        redisTemplate.opsForHash().put(map,key,value);
    }
    public Object get(String map,String key) {
        return redisTemplate.opsForHash().get(map,key);
    }
    public void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
