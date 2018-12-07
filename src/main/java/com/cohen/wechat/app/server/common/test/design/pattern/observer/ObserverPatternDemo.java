package com.cohen.wechat.app.server.common.test.design.pattern.observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        MyService service = new MyService();
        String s = service.doService();
    }
}