

# Docker-IDEA 测试项目

这是一个基于 Docker 和 Spring Boot 的简单项目，主要用于测试 Docker 容器中 Java 应用的运行和 Redis 缓存服务的集成。

## 项目概述

该项目主要展示了以下功能：

- 基于 Spring Boot 构建的简单 Web 应用
- Redis 缓存的集成配置与使用
- 基本的 REST API 支持
- Docker 容器化部署

适用于学习如何将 Java 应用打包为 Docker 镜像并在容器中运行。

## 特性

- 使用 Spring Boot 快速搭建 Web 应用
- Redis 缓存服务配置和测试
- 支持 GET 和 POST 请求的 API 接口
- 使用 Dockerfile 构建容器镜像
- 提供统一的 API 响应格式（ApiResponse）

## 安装与部署

### 构建 Docker 镜像

1. 确保项目已打包为 JAR 文件。
2. 在项目根目录下运行以下命令：

```bash
docker build -t docker-test .
```

### 运行容器

```bash
docker run -d -p 8080:8080 docker-test
```

## 使用示例

### 基本 API

- `GET /hello`: 返回欢迎语，支持传参 `name`
- `GET /user`: 返回用户信息
- `POST /save_user`: 保存用户信息
- `GET /html`: 返回 HTML 页面

### Redis 操作

- `GET /api/redis/get`: 获取 Redis 中的键值
- `POST /api/redis/set`: 设置 Redis 中的键值对

### 响应格式

所有 API 响应均采用统一格式：

```json
{
  "code": 200,
  "message": "操作成功",
  "data": "返回的数据",
  "timestamp": "2023-10-01T12:00:00"
}
```

## 开发与测试

- 使用 `pom.xml` 构建项目
- 配置文件位于 `application.yml`
- 日志使用 `logback-spring.xml` 进行管理

## 异常处理

全局异常处理类 `GlobalExceptionHandler` 会统一捕获并返回格式化的错误信息。

## 模板文件

- `src/main/resources/public/index.html`: 静态页面
- `src/main/resources/templates/index.html`: 模板页面

## 测试用例

- `DockerTestApplicationTests`: Spring Boot 测试基类
- `RedisTest`: Redis 功能测试类

## 许可证

请查看 LICENSE 文件获取详细信息。

## 注意事项

- 项目使用 `openjdk:8-jre-alpine` 镜像，适合轻量容器运行
- Redis 配置基于 `LettuceConnectionFactory`
- 所有 API 使用 `/api/redis` 前缀进行统一管理

如需更多帮助，请参考项目文档或联系项目维护者。