package com.cohen.wechat.app.server.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    private void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}