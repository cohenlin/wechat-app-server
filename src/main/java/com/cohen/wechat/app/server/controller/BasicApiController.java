package com.cohen.wechat.app.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic/api")
public class BasicApiController {

    @PostMapping("/hello")
    public String hello(){
        return "I'm wechat-app-server";
    }
}