package com.mouse.java.collection.queue.block;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description LinkedBlockingQueue 底层基于一个单链表实现
 * 内部通过重入锁ReenterLock和Condition条件队列实现 两把锁 从队尾插入的putLock和从对头删除的takeLock 添加和删除可并发执行 满和空两个队列 通过一把锁实现添加和删除的并发访问
 * LinkedBlockingQueue比ArrayBlockingQueue有更高的吞吐量，但是性能表现更难预测
 *
 * remove方法删除指定的对象，为什么同时对putLock和takeLock加锁？这是因为remove方法删除的数据的位置不确定，为了避免造成并非安全问题，所以需要对2个锁同时加锁。
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.add("mouse");
        linkedBlockingQueue.remove("mouse");
    }

}
