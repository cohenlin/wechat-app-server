package com.cohen.wechat.app.server.service.impl;

import com.cohen.wechat.app.server.common.ServerResponse;
import com.cohen.wechat.app.server.dao.TaskDao;
import com.cohen.wechat.app.server.entity.Task;
import com.cohen.wechat.app.server.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author linjincheng
 * @date 2018/11/15 18:20
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public String create(String start, String end, String isNotice, String openid, String remark) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            taskDao.create(new Task(UUID.randomUUID().toString().replaceAll("-", ""), sdf.parse(start), sdf.parse(end), isNotice, openid, remark));
            return new ServerResponse<String>("200", "SUCCESS", null).toString();
        } catch (ParseException e) {
            return new ServerResponse<String>("500", "ERROR", e.getMessage()).toString();
        }
    }

    @Override
    public String getLastEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date lastEndTime = taskDao.getLastEndTime();
            return new ServerResponse<String>("200", "SUCCESS", sdf.format(lastEndTime)).toString();
        } catch (Exception e) {
            return new ServerResponse<String>("200", "SUCCESS", sdf.format(new Date())).toString();
        }
    }
}