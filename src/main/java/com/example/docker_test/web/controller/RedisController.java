package com.example.docker_test.web.controller;

import java.io.Serializable;

import com.example.docker_test.web.entity.RedisQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: zhoupengcheng
 * @Date: 2025/8/2/0002 -08 -02 -20:55
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @RequestMapping(value = "/set", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String set(@RequestBody RedisQuery redisQuery) {
        String key = redisQuery.getKey();
        String value = redisQuery.getValue();
        stringRedisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @RequestMapping(value = "/get", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String get(@RequestBody RedisQuery redisQuery) {
        String key = redisQuery.getKey();
        return stringRedisTemplate.opsForValue().get(key);
    }

}
