FROM r.cn/pub/jdk:1.8
ENV  appName wechat-app-server
ENV  LANG en_US.UTF-8
ARG  env
ARG  idc=default
ENV  env=${env}
ENV  idc=${idc}
RUN  mkdir -p /opt/settings/ && echo "env=${env}" > /opt/settings/server.properties && echo "idc=${idc}" >> /opt/settings/server.properties
COPY target/$appName.jar /opt/
ENTRYPOINT java -server -Xms1g -Xmx1g -Xmn512m -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m -jar /opt/$appName.jar