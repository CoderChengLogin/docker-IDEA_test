# 基础镜像：java 8镜像不存在，则自动下载
FROM java:8
# 指定维护者信息
MAINTAINER pczhou
# 容器数据卷，用于数据保存和持久化
VOLUME /tmp
# 将target目录下jar包拷贝到容器/目录下，并更名为app.jar
ADD target/*.jar /app.jar
# Docker容器启动时运行jar包
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]