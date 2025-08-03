# Docker-IDEA Test Project

This is a simple project based on Docker and Spring Boot, mainly used to test the operation of Java applications in Docker containers and the integration of Redis caching services.

## Project Overview

This project mainly demonstrates the following functions:

- A simple Web application built with Spring Boot
- Integration, configuration, and usage of Redis caching
- Support for basic REST APIs
- Docker containerization deployment

Suitable for learning how to package Java applications into Docker images and run them in containers.

## Features

- Rapid Web application setup using Spring Boot
- Redis cache service configuration and testing
- API interfaces supporting GET and POST requests
- Building container images using Dockerfile
- Providing a unified API response format (ApiResponse)

## Installation and Deployment

### Building the Docker Image

1. Ensure the project has been packaged into a JAR file.
2. Run the following command in the project root directory:

```bash
docker build -t docker-test .
```

### Running the Container

```bash
docker run -d -p 8080:8080 docker-test
```

## Usage Examples

### Basic APIs

- `GET /hello`: Returns a welcome message, supports passing the `name` parameter
- `GET /user`: Returns user information
- `POST /save_user`: Saves user information
- `GET /html`: Returns an HTML page

### Redis Operations

- `GET /api/redis/get`: Retrieves key-value pairs from Redis
- `POST /api/redis/set`: Sets key-value pairs in Redis

### Response Format

All API responses use a unified format:

```json
{
  "code": 200,
  "message": "Operation successful",
  "data": "Returned data",
  "timestamp": "2023-10-01T12:00:00"
}
```

## Development and Testing

- The project is built using `pom.xml`
- Configuration files are located in `application.yml`
- Logging is managed using `logback-spring.xml`

## Exception Handling

The global exception handler class `GlobalExceptionHandler` uniformly captures and returns formatted error messages.

## Template Files

- `src/main/resources/public/index.html`: Static page
- `src/main/resources/templates/index.html`: Template page

## Test Cases

- `DockerTestApplicationTests`: Spring Boot base test class
- `RedisTest`: Redis functionality test class

## License

Please refer to the LICENSE file for detailed information.

## Notes

- The project uses the `openjdk:8-jre-alpine` image, suitable for lightweight container operation
- Redis configuration is based on `LettuceConnectionFactory`
- All APIs are uniformly managed using the `/api/redis` prefix

For more help, please refer to the project documentation or contact the project maintainer.