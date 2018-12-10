package com.cohen.wechat.app.server.common.test.strategy.billcheck;

import com.cohen.wechat.app.server.common.test.strategy.StrategyFactory;
import com.cohen.wechat.app.server.common.test.strategy.StrategyType;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 18:12
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public interface BillCheckStrategyFactory extends StrategyFactory {
    @Override
    BillCheckStrategy getStrategy(StrategyType type);
}
