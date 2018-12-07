package com.cohen.wechat.app.server.common.test.strategy.billcheck;

import com.cohen.wechat.app.server.common.test.strategy.StrategyType;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 17:44
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public enum BillCheckStrategyType implements StrategyType {
    /**
     * mq日志至boh库
     */
    MQ_LOG_TO_BOH,
    /**
     * boh库至云端mysq
     */
    BOH_TO_CLOUD_MYSQL,
    /**
     * 云端mysql至非码
     */
    CLOUD_MYSQL_TO_FREEMUD;
}
