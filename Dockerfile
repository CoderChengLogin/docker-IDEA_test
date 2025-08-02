# 基础镜像：java 8镜像不存在，则自动下载
FROM openjdk:8-jre-alpine
# 作者信息
LABEL maintainer="pczhou"

# 设置时区（避免容器内时间不一致问题）
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 设置容器内的工作目录，全局式的，相当于cd /app 之后的所有操作都在这个文件夹下
WORKDIR /app

# 这一句是构建核心，往容器中添加jar包，注意这里要和maven打包后的项目名字一致，还有路径也在容器里是固定的
COPY target/*.jar app.jar

# 启动镜像自动运行程序
ENTRYPOINT ["java", \
     "-Djava.security.egd=file:/dev/./urandom", \
     "-XX:+UnlockExperimentalVMOptions", \
     "-XX:+UseContainerSupport", \
     "-XX:MaxRAMPercentage=90.0", \
     "-jar", \
     "app.jar"]