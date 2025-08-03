package com.example.docker_test.web.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: zhoupengcheng
 * @Date: 2025/8/3/0003 -08 -03 -9:47
 *
 * 通用API响应包装类
 * 用于统一Controller层的返回格式，便于于前端端统一处理
 */
@Data
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {
    // 成功状态的默认状态码
    public static final int SUCCESS_CODE = 200;
    // 成功状态的默认消息
    public static final String SUCCESS_MESSAGE = "操作成功";
    // 错误状态的默认状态码
    public static final int ERROR_CODE = 500;
    // 错误状态的默认消息
    public static final String ERROR_MESSAGE = "操作失败";
    private static final long serialVersionUID = 1L;
    // 时间格式化器
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // 状态码：200表示成功，其他表示错误
    private int code;
    // 返回消息
    private String message;
    // 返回数据
    private T data;
    // 时间戳
    private String timestamp;

    /**
     * 全参构造函数
     *
     * @param code    状态码
     * @param message 消息
     * @param data    数据
     */
    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now().format(FORMATTER);
    }

    /**
     * 创建成功的响应对象（不带数据）
     *
     * @param <T> 数据类型
     * @return 成功的响应对象
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    /**
     * 创建成功的响应对象（带数据）
     *
     * @param data 要返回的数据
     * @param <T>  数据类型
     * @return 成功的响应对象
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    /**
     * 创建成功的响应对象（带自定义消息和数据）
     *
     * @param message 自定义消息
     * @param data    要返回的数据
     * @param <T>     数据类型
     * @return 成功的响应对象
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(SUCCESS_CODE, message, data);
    }

    /**
     * 创建错误的响应对象（不带数据）
     *
     * @param <T> 数据类型
     * @return 错误的响应对象
     */
    public static <T> ApiResponse<T> error() {
        return new ApiResponse<>(ERROR_CODE, ERROR_MESSAGE, null);
    }

    /**
     * 创建错误的响应对象（带自定义消息）
     *
     * @param message 错误消息
     * @param <T>     数据类型
     * @return 错误的响应对象
     */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(ERROR_CODE, message, null);
    }

    /**
     * 创建错误的响应对象（带自定义状态码和消息）
     *
     * @param code    错误状态码
     * @param message 错误消息
     * @param <T>     数据类型
     * @return 错误的响应对象
     */
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    /**
     * 创建错误的响应对象（带自定义状态码、消息和数据）
     *
     * @param code    错误状态码
     * @param message 错误消息
     * @param data    错误相关数据
     * @param <T>     数据类型
     * @return 错误的响应对象
     */
    public static <T> ApiResponse<T> error(int code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }
}
