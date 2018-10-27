package com.cohen.wechat.app.server.common;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

@Service
public final class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param url
     * @param params
     * @return
     */
    public JSONObject postRequest(String url, Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.setAll(params);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        ResponseEntity<Object> response = null;
        JSONObject jsonObject = new JSONObject();
        try {
            response = restTemplate.postForEntity(url, request, Object.class);
            if (response != null) {
                jsonObject.put("success", true);
                jsonObject.put("data", response.getBody());
                jsonObject.put("code", 200);
                jsonObject.put("msg", "请求成功");
            }
        } catch (RestClientException e) {
            jsonObject.put("success", false);
            jsonObject.put("code", 500);
            jsonObject.put("msg",
                    "请求异常，异常信息：" + e.getClass() + "->" + e.getMessage());
        }
        return jsonObject;
    }

    /**
     * @param url
     * @param request
     * @return
     */
    public JSONObject postRequest(String url, String request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        JSONObject response = null;
        try {
            HttpEntity<String> formEntity = new HttpEntity<String>(request, headers);
            response = restTemplate.postForObject(url, formEntity, JSONObject.class);
            if (response != null) {
                jsonObject.put("success", true);
                jsonObject.put("data", response);
                jsonObject.put("code", 200);
                jsonObject.put("msg", "请求成功");
            }
        } catch (RestClientException e) {
            jsonObject.put("success", false);
            jsonObject.put("code", 500);
            jsonObject.put("msg",
                    "请求异常，异常信息：" + e.getClass() + "->" + e.getMessage());
        }
        return jsonObject;
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public JSONObject getRequest(String url) {
        JSONObject result = new JSONObject();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(url, String.class);
            if (response != null) {
                result.put("success", true);
                result.put("data", response.getBody());
                result.put("code", 200);
                result.put("msg", "请求成功");
            }
        } catch (RestClientException e) {
            result.put("success", false);
            result.put("code", 500);
            result.put("msg", "请求异常，异常信息：" + e.getClass() + "->" + e.getMessage());
        }
        return result;
    }
}