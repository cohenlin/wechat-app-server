package com.cohen.wechat.app.server.common.test.strategy.billcheck;

import com.cohen.wechat.app.server.common.test.strategy.Strategy;

import java.util.List;

/**
 * 账单对比策略
 *
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 17:36
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public interface BillCheckStrategy extends Strategy {
    /**
     * 对比订单
     *
     * @param before 链路中前一个模块
     * @param after  链路中后一个模块
     * @return 前后账单差异
     */
    List<String> checkBill(List<String> before, List<String> after);
}
