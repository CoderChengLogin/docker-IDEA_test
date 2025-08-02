package com.example.docker_test.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: zhoupengcheng
 * @Date: 2025/8/2/0002 -08 -02 -20:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisQuery {

    private String key;
    private String value;

}
