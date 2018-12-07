package com.cohen.wechat.app.server.common.test.strategy.billcheck;

import com.cohen.wechat.app.server.common.test.strategy.StrategyType;

import java.util.HashMap;
import java.util.Map;

/**
 * 账单校验策略工厂
 *
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 17:47
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class BillCheckStrategyFactoryImpl implements BillCheckStrategyFactory {

    private Map<StrategyType, BillCheckStrategy> strategys;

    public BillCheckStrategyFactoryImpl() {
        this.strategys = new HashMap<>();
    }

    public BillCheckStrategyFactoryImpl(Map<StrategyType, BillCheckStrategy> strategys) {
        this.strategys = strategys;
    }

    public void addStrategy(StrategyType type, BillCheckStrategy strategy) {
        if (!this.strategys.containsKey(type)) {
            this.strategys.put(type, strategy);
        }
    }

    @Override
    public BillCheckStrategy getStrategy(StrategyType type) {
        return this.strategys.get(type);
    }
}