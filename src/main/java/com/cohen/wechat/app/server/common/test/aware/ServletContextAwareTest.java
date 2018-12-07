package com.cohen.wechat.app.server.common.test.aware;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Map;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/11/30 16:12
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
@Component
public class ServletContextAwareTest implements ApplicationContextAware, ServletContextAware {
    ServletContext servletContext;
    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void doSomething() {
        Map<String, ? extends ServletRegistration> servletRegistrations = this.servletContext.getServletRegistrations();
        for (Map.Entry<String, ? extends ServletRegistration> stringEntry : servletRegistrations.entrySet()) {
            System.out.println(JSON.toJSONString(stringEntry));
        }
    }
}
