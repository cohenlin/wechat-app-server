package com.cohen.wechat.app.server.common.test.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    /**
     * 观察者集合
     */
    protected List<Observer> observers = new ArrayList<>();

    /**
     * 业务方法是否执行完成
     */
    protected final String execute(Service service) {
        String s = service.doService();
        notifyAllObservers();
        return s;
    }

    /**
     * 注册观察者
     *
     * @param observer 观察者
     */
    protected void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知所有观察者
     */
    protected void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}