package com.cohen.wechat.app.server.common.test.strategy.billcheck;

import java.util.List;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 18:08
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class CloudMysqlToFreemudBillCheckStrategy implements BillCheckStrategy {
    @Override
    public List<String> checkBill(List<String> before, List<String> after) {
        return null;
    }
}