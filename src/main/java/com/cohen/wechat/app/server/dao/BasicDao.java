package com.cohen.wechat.app.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BasicDao {
    void insert(@Param("id") String id, @Param("openid") String openId);
}