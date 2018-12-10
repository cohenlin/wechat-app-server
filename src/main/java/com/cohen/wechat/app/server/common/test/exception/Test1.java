package com.cohen.wechat.app.server.common.test.exception;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/11/30 14:16
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class Test1 {
    public void test() {
        Test2 test2 = new Test2();
        test2.test();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        try {
            test1.test();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}