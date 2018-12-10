package com.cohen.wechat.app.server.controller;

import com.cohen.wechat.app.server.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author linjincheng
 * @date 2018/11/15 17:11
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public String create(
            @RequestParam("start") String start,
            @RequestParam("end") String end,
            @RequestParam("isNotice") String isNotice,
            @RequestParam("openid") String openid,
            @RequestParam("remark") String remark
    ) {
            return taskService.create(start, end, isNotice, openid, remark);
    }

    @PostMapping("/getLastEndTime")
    public String getLastEndTime () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ins = Calendar.getInstance();
        Date time1 = ins.getTime();
        ins.set(Calendar.DAY_OF_MONTH, ins.get(Calendar.DAY_OF_MONTH) + 1);
        Date time2 = ins.getTime();
        String start = sdf.format(time1);
        String end = sdf.format(time2);
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return taskService.getLastEndTime();
    }
}