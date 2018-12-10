package com.cohen.wechat.app.server.service;

/**
 * @author linjincheng
 * @date 2018/11/15 18:18
 */
public interface TaskService {
    String create(String start, String end, String isNotice, String openid, String remark);
}