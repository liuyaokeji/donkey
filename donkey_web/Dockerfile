#使用jdk8作为基础镜像
FROM openjdk:8-jre
#指定作者
MAINTAINER liuyao
#暴漏容器的10240端口
EXPOSE 10240
WORKDIR app
#将复制指定的docker-demo-0.0.1-SNAPSHOT.jar为容器中的app.jar，相当于拷贝到容器中取了个别名
COPY target/donkey_web-0.0.1-SNAPSHOT.jar app.jar
#设置时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD ["java", "-jar", "app.jar"]