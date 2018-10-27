package com.cohen.wechat.app.server;

import com.cohen.wechat.app.server.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {

    @Autowired
    private TestController controller;

    @Test
    public void test(){
        controller.ping("hello");
    }
}