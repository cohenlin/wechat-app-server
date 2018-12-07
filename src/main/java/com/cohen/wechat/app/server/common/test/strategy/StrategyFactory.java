package com.cohen.wechat.app.server.common.test.strategy;

/**
 * 策略工厂
 *
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 17:39
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public interface StrategyFactory {
    /**
     * 策略工厂
     *
     * @param type 策略类型
     */
    Strategy getStrategy(StrategyType type);
}
