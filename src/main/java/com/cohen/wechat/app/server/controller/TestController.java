package com.cohen.wechat.app.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.cohen.wechat.app.server.common.HttpUtil;
import com.cohen.wechat.app.server.config.ApplicationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {

    private final String CODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private ApplicationParameter applicationParameter;

    @PostMapping("/codeToSession")
    public String ping(@RequestParam("code")String code){
        String targetUrl = CODE_TO_SESSION_URL.concat("?")
                .concat("appid").concat(applicationParameter.getWechatAppId())
                .concat("&secret").concat(applicationParameter.getWechatAppSecret())
                .concat("&js_code").concat(code)
                .concat("&grant_type=authorization_code");
        JSONObject response = httpUtil.getRequest(targetUrl);
        if(response != null && "200".equalsIgnoreCase(response.getString("code")) && response.containsKey("data")){
            JSONObject data = response.getJSONObject("data");
            Integer errcode = data.getInteger("errcode");
            switch (errcode){
                case -1:
                    response.put("msg", "系统繁忙，此时请开发者稍候再试");
                    break;
                case 0:
                    response.put("msg", "請求成功");
                    break;
                case 40029:
                    response.put("msg", "code无效");
                    break;
                case 45011:
                    response.put("msg", "频率限制，每个用户每分钟100次");
                    break;
            }
            response.put("code", String.valueOf(errcode));
        }
        return response.toJSONString();
    }
}