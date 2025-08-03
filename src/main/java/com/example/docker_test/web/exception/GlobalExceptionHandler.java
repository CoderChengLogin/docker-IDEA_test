package com.example.docker_test.web.exception;

import com.example.docker_test.web.entity.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: zhoupengcheng
 * @Date: 2025/8/3/0003 -08 -03 -10:03
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        log.error("系统异常:", e);
        // 返回统一的错误信息，避免泄露具体异常细节
        return ApiResponse.error("操作失败，请联系管理员");
    }

    // 可以针对特定异常添加更具体的处理
    @ExceptionHandler(RedisConnectionFailureException.class)
    public ApiResponse<String> handleRedisException(RedisConnectionFailureException e) {
        log.error("Redis连接异常:", e);
        return ApiResponse.error("Redis连接失败，请检查服务状态");
    }
}