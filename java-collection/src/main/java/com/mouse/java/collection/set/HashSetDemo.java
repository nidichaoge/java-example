package com.mouse.java.collection.set;

import java.util.HashSet;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description HashSet 底层基于HashMap实现,实际上使用了HashMap的key, 而value是类型为Object的PRESENT 线程不安全 元素不可重复
 * 需要元素重写hashcode和equals方法
 * <p>
 * 不能保证元素的排列顺序，顺序有可能发生变化
 * 不是同步的
 * 集合元素可以是null,但只能放入一个null不能保证元素的排列顺序，顺序有可能发生变化
 */
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String> objects = new HashSet<>();
        objects.add("mouse");
    }

}
