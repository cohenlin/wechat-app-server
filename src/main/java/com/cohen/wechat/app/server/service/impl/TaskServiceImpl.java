package com.cohen.wechat.app.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.cohen.wechat.app.server.common.ServerResponse;
import com.cohen.wechat.app.server.dao.TaskDao;
import com.cohen.wechat.app.server.entity.Task;
import com.cohen.wechat.app.server.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public String create(String start, String end, String isNotice, String openid, String remark) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            Task task = new Task(id, sdf.parse(start), sdf.parse(end), isNotice, openid, remark);
            redisTemplate.opsForValue().set(id, JSON.toJSONString(task));
            taskDao.create(task);
            this.stay();
            return new ServerResponse<String>("200", "SUCCESS", null).toString();
        } catch (ParseException e) {
            return new ServerResponse<String>("500", "ERROR", e.getMessage()).toString();
        }
    }

    private void stay(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
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