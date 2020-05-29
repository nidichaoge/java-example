package com.mouse.java.collection.set;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description CopyOnWriteArraySet 底层其实是基于CopyOnWriteArrayList
 * new CopyOnWriteArraySet<>(); 其实是实例化了一个CopyOnWriteArrayList的对象
 * add方法其实是调用CopyOnWriteArrayList#addIfAbsent方法去进行判断是否重复
 */
public class CopyOnWriteArraySetDemo {

    public static void main(String[] args) {
        CopyOnWriteArraySet<String> objects = new CopyOnWriteArraySet<>();
        objects.add("mouse");
    }

}
