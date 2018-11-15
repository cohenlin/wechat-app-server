package com.cohen.wechat.app.server.controller;

import com.cohen.wechat.app.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/codeToSession")
    public String codeToSession(@RequestParam("code") String code) {
        return userService.codeToSession(code);
    }

    @PostMapping("/insertNickName")
    public String insertNickName(@RequestParam("nickName") String nickName) {
        return userService.codeToSession(nickName);
    }
}