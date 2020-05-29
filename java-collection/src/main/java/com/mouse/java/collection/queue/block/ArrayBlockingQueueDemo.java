package com.mouse.java.collection.queue.block;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description ArrayBlockingQueue 底层基于Object类型的数组实现 线程安全
 * 内部通过重入锁ReenterLock和Condition条件队列实现 一把锁 满和空两个队列 通过一把锁实现添加和删除的并发访问
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1024);

        /**
         * 内部实际上获取的offer方法，当Queue已经满了时，抛出一个异常。不会阻塞
         */
        arrayBlockingQueue.add("mouse");

        /**
         * 移除指定元素,成功返回true，失败返回false
         */
        arrayBlockingQueue.remove("mouse");

        /**
         * 获取并移除此队列的头元素，若队列为空，则返回 null
         */
        arrayBlockingQueue.poll();

        /**
         *
         */
        arrayBlockingQueue.peek();

        /**
         * 当Queue已经满了时，返回false。不会阻塞
         */
        arrayBlockingQueue.offer("mouse1");

        //-------------------------------------------------------------------//

        /**
         * 当Queue已经满了时，会进入等待，只要不被中断，就会插入数据到队列中。会阻塞，可以响应中断。
         */
        try {
            arrayBlockingQueue.put("mouse2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 当Queue已经空了时，会进入等待，只要不被中断，就会移除数据。会阻塞，可以响应中断。
         */
        try {
            arrayBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
