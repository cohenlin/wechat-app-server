package com.cohen.wechat.app.server.common.filter;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/11/29 13:07
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public interface Filter {
    void doFilter(Object client, Object request, FilterChain filterChain);

    Integer order();
}