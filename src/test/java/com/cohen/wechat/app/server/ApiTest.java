package com.cohen.wechat.app.server;

import com.alibaba.fastjson.JSON;
import com.cohen.wechat.app.server.dao.TaskDao;
import com.cohen.wechat.app.server.entity.Task;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {
    @Autowired
    private TaskDao taskDao;

    @Test
    public void testPageHelper() {
        Page<Task> tasks = PageHelper.startPage(1, 1, true);
        taskDao.select();
        System.out.println(JSON.toJSONString(tasks.getResult()));
    }
}