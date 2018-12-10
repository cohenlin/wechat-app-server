package com.cohen.wechat.app.server.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author: songyibo
 * @Date: 2018/9/6
 */
//@Aspect
//@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.cohen.wechat.app.server.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录下请求内容
        Signature signature = joinPoint.getSignature();
        logger.info("[REQUEST] - Method: [{}.{}], Args: {}", signature.getDeclaringTypeName(), signature.getName(), JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        // 处理完请求，返回内容
        Signature signature = joinPoint.getSignature();
        logger.info("[RESPONSE] - Method: [{}.{}], Response: [{}]", signature.getDeclaringTypeName(), signature.getName(), result);
    }
}