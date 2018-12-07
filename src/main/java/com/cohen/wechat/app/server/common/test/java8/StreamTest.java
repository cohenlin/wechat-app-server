package com.cohen.wechat.app.server.common.test.java8;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/5 10:10
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class StreamTest {

    class Student {
        private String id;
        private Integer age;
        private String name;

        public Student(String id, Integer age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private List<Student> list;

    public StreamTest() {
        this.init();
    }

    public void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            list.add(new Student(id, i + 20, "Student" + i));
        }
    }

    /**
     * 匹配list是否含有年龄为25的元素，有则返回true
     */
    public void testStreamAnyMatch() {
        boolean b = list.stream().anyMatch(item -> 25 == item.getAge());
        System.out.println(b);
    }

    /**
     * 匹配list中是否所有的元素的name属性都包含“Student”
     */
    public void testStreamAllMatch() {
        boolean b = list.stream().allMatch(item -> item.getName().contains("Student"));
        System.out.println(b);
    }

    /**
     * 过滤出年龄大于25的元素
     */
    public void testStreamFilter() {
        List<Student> collect = list.stream().filter(item -> item.getAge() > 25).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    /**
     * 处理list中的元素，映射为其他元素
     */
    public void testStreamMap() {
        List<Object> collect = list.stream().map(item -> JSON.toJSON(item)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.testStreamAnyMatch();
        streamTest.testStreamAllMatch();
        streamTest.testStreamFilter();
        streamTest.testStreamMap();
    }
}