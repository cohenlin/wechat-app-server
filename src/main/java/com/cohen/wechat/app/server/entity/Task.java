package com.cohen.wechat.app.server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linjincheng
 * @date 2018/11/15 18:27
 */
public class Task implements Serializable {

    private static final long serialVersionUID = -4254224180130337914L;

    private String id;
    private String start;
    private String end;
    private String isNotice;
    private String openid;
    private String remark;
    private Date updateTime;
    private String deleteFlag;

    public Task(String id, String start, String end, String isNotice, String openid, String remark) {
        this.start = start;
        this.end = end;
        this.isNotice = isNotice;
        this.openid = openid;
        this.remark = remark;
        this.updateTime = new Date();
    }

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(String isNotice) {
        this.isNotice = isNotice;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return new Date();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return new Date();
    }
}