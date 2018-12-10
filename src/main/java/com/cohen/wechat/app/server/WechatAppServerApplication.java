package com.cohen.wechat.app.server;

import com.cohen.wechat.app.server.common.test.aware.ServletContextAwareTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.cohen.wechat.app.**.dao")
@EnableEurekaClient
public class WechatAppServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WechatAppServerApplication.class, args);
        ServletContextAwareTest bean = run.getBean(ServletContextAwareTest.class);
        bean.doSomething();
    }
}
