package com.example.docker_test.web.controller;

import java.io.Serializable;

import com.example.docker_test.web.entity.ApiResponse;
import com.example.docker_test.web.entity.RedisQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoupengcheng
 * @date 2025/8/2 20:55
 *
 * Redis操作控制器
 * 提供Redis的基本操作接口，包括设置键值对和获取键值
 */
@RestController // 替代@Controller + @ResponseBody，更简洁
@RequestMapping("/api/redis") // 统一添加api前缀，便于区分接口路径
@Slf4j
public class RedisController {

    // 常量定义，便于维护和统一修改
    private static final String OPERATE_SUCCESS = "操作成功";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    /**
     * 设置Redis键值对
     */
    @RequestMapping(value = "/set", method = {RequestMethod.POST, RequestMethod.GET})
    public ApiResponse<String> set(@RequestBody RedisQuery redisQuery) {
        String key = redisQuery.getKey();
        String value = redisQuery.getValue();
        log.info("设置Redis键值对，key: {}, value: {}", key, value);
        stringRedisTemplate.opsForValue().set(key, value);
        return ApiResponse.success(OPERATE_SUCCESS);
    }

    /**
     * 获取Redis键对应的值
     *
     * @return 键对应的值，如果不存在则返回null
     */
    @RequestMapping(value = "/get", method = {RequestMethod.POST, RequestMethod.GET})
    public ApiResponse<String> get(@RequestBody RedisQuery redisQuery) {
        String key = redisQuery.getKey();
        log.info("获取Redis键值，key: {}", key);
        return ApiResponse.success(stringRedisTemplate.opsForValue().get(key));
    }
}
