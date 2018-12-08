package com.cohen.wechat.app.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BasicApiController {

    @GetMapping("/hello")
    public String hello() {
        System.out.print("I'm wechat-app-server");
        return "I'm wechat-app-server";
    }
}
