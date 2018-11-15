package com.cohen.wechat.app.server.controller;

import com.cohen.wechat.app.server.service.TimerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linjincheng
 * @date 2018/11/15 17:11
 */
@RestController
@RequestMapping("/task")
public class TimerController {
    private static final Logger LOG = LoggerFactory.getLogger(TimerController.class);
    @Autowired
    private TimerService timerService;

    @PostMapping("/create")
    public String create(
            @RequestParam("start") String start,
            @RequestParam("end") String end,
            @RequestParam("isNotice") String isNotice,
            @RequestParam("openid") String openid,
            @RequestParam("remark") String remark
    ) {
        return timerService.create(start, end, isNotice, openid, remark);
    }
}