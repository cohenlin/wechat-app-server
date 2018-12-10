package com.cohen.wechat.app.server.controller;

import com.cohen.wechat.app.server.common.response.ServerResponse;
import com.cohen.wechat.app.server.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BasicApiController {

    @GetMapping("/hello")
    public String hello() {
        List<User> list = new ArrayList<>();
        list.add(new User("刘德华", 18, "西湖区湖底公园1号"));
        list.add(new User("吴彦祖", 19, "西湖区湖底公园2号"));
        list.add(new User("周润发", 20, "西湖区湖底公园3号"));
        return ServerResponse.createBySuccess(list);
    }
}