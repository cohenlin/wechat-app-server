package com.cohen.wechat.app.server.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/11/28 16:17
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
@Order(-100)
@Component
public class Filter2 implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(Filter2.class);

    @Override
    public void doFilter(Object client, Object request, com.cohen.wechat.app.server.common.filter.FilterChain filterChain) {

    }

    @Override
    public Integer order() {
        return 1;
    }
}