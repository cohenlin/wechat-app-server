package com.cohen.wechat.app.server.config.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author 林金成
 * @date 2018/8/23 16:38
 */
@Component
public class Scheduler {

    /**
     * 处理任务提醒
     */
    @Scheduled(fixedDelay = 60000)
    public void taskScheduler() {
    }
}