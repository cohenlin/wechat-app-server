package com.cohen.wechat.app.server.common.test.design.pattern.observer;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/7 16:59
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class MyService implements Service {
    @Override
    public String doService() {
        System.out.println("开始执行业务方法");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i + 1);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("业务方法执行完毕！");
        return null;
    }
}
