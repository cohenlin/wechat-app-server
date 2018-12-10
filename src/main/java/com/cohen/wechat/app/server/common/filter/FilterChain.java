package com.cohen.wechat.app.server.common.filter;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/11/29 13:07
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class FilterChain {
    /**
     * 过滤器，有序
     */
    private List<Filter> filters = new ArrayList<>();
    /**
     * 当前执行过滤器的下标
     */
    private ThreadLocal<Integer> _index = new ThreadLocal<>();
    /**
     * 当前执行到的过滤器位置
     */
    private int _size = 0;

    @Autowired
    private Object dispatcher;

    /**
     * 依次执行过滤器
     */
    public void doFilter(Object client, Object request) throws Exception {
        Integer index = this._index.get() == null ? 0 : this._index.get();
        if (index < this._size) {
            // 调用下一个过滤器
            Filter filter = this.filters.get(index);
            this._index.set(index + 1);
            try {
                filter.doFilter(client, request, this);
            } catch (Exception e) {
                this._index.set(null);
                throw e;
            }
            return;
        }

        // 过滤器已经执行完毕，调用业务方法
//        try {
//            this.dispatcher.test(client, request);
//        } catch (Exception e) {
//            throw new RuntimeException("service execute exception: [" + e.getMessage() + "]");
//        } finally {
//            this._index.set(null);
//        }
    }

    /**
     * 注册过滤器
     */
    public FilterChain registerFilter(Filter filter) {
        this.filters.add(filter);
        this._size++;
        this.filters.sort(Comparator.comparing(Filter::order));
        return this;
    }
}