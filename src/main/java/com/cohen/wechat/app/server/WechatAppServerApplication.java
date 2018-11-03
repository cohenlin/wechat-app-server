package com.cohen.wechat.app.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.cohen.wechat.app.**.dao")
@EnableEurekaClient
public class WechatAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatAppServerApplication.class, args);
    }
}
