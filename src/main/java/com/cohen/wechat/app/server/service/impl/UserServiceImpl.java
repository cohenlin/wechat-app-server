package com.cohen.wechat.app.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cohen.wechat.app.server.common.HttpUtil;
import com.cohen.wechat.app.server.config.ApplicationParameter;
import com.cohen.wechat.app.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linjincheng
 * @date 2018/10/30 18:30
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private ApplicationParameter applicationParameter;
    @Autowired
    private HttpUtil httpUtil;
    private final String CODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    @Override
    public String codeToSession(String code) {
        String targetUrl = CODE_TO_SESSION_URL.concat("?")
                .concat("appid=").concat(applicationParameter.getWechatAppId())
                .concat("&secret=").concat(applicationParameter.getWechatAppSecret())
                .concat("&js_code=").concat(code)
                .concat("&grant_type=authorization_code");
        LOG.info("[method]:[codeToSession] targetUrl = {}", targetUrl);
        JSONObject response = httpUtil.getRequest(targetUrl);
        LOG.info("[method]:[codeToSession] wechat-response = {}", response.toJSONString());
        if ("200".equalsIgnoreCase(response.getString("code")) && response.containsKey("data")) {
            JSONObject data = response.getJSONObject("data");
            Integer errcode = data.containsKey("errcode") ? data.getInteger("errcode") : 0;
            switch (errcode) {
                case -1:
                    response.put("msg", "系统繁忙，此时请开发者稍候再试");
                    break;
                case 0:
                    response.put("msg", "請求成功");
                    response.put("openid", data.getString("openid"));
                    response.put("session_key", data.getString("session_key"));
                    response.put("unionid", data.getString("unionid"));
                    break;
                case 40029:
                    response.put("msg", "code无效");
                    break;
                case 45011:
                    response.put("msg", "频率限制，每个用户每分钟100次");
                    break;
                default:
            }
            response.put("code", String.valueOf(errcode));
        }
        return response.toJSONString();
    }
}