package com.mouse.java.collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description ConcurrentHashMap 线程安全 性能相对较好
 * synchronized CAS
 *
 * synchronized
 * 在put操作中, synchronized的加锁对象是链表或红黑树的头节点
 *
 * 1.8以前是分段锁的思想 即一个一个的Segment
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("mouse", "mouse");
        concurrentHashMap.get("mouse");
    }

}
