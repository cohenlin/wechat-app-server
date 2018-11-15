package com.cohen.wechat.app.server.service.impl;

import com.cohen.wechat.app.server.dao.TaskDao;
import com.cohen.wechat.app.server.entity.Task;
import com.cohen.wechat.app.server.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author linjincheng
 * @date 2018/11/15 18:20
 */
@Service
public class TimerServiceImpl implements TimerService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public String create(String start, String end, String isNotice, String openid, String remark) {
        taskDao.create(new Task(UUID.randomUUID().toString().replaceAll("-", ""), start, end, isNotice, openid, remark));
        return "success";
    }
}