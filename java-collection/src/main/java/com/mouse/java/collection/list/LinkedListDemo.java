package com.mouse.java.collection.list;

import java.util.LinkedList;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description LinkedList 底层基于双向链表实现 线程不安全 添加和删除更快 访问较慢 无需扩容
 * 实现了 Deque 接口
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> objects = new LinkedList<>();
        /**
         * 添加到尾部
         */
        objects.add("mouse");
        objects.addLast("mouse");
        objects.offerLast("mouse");

        /**
         * 添加到首部
         */
        objects.addFirst("mouse");
        objects.offerFirst("mouse");

        /**
         * 添加到指定位置
         */
        objects.add(1, "mouse");

        objects.get(0);
    }

}
