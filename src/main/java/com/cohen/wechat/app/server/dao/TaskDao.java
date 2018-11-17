package com.cohen.wechat.app.server.dao;

import com.cohen.wechat.app.server.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author linjincheng
 * @date 2018/11/15 18:26
 */
@Mapper
@Component
public interface TaskDao {
    void create(@Param("task") Task task);
    Date getLastEndTime();
}