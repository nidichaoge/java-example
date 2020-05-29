package com.mouse.java.collection.list;

import java.util.Vector;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description Vector 底层基于Object类型的数组实现 线程安全 支持快速随机访问 性能相对ArrayList差一些 需要加锁
 * <p>
 * 使用 new Vector<>(); 创建实例时直接分配默认容量为10的数组，没有做优化
 * <p>
 * 线程安全
 * 使用synchronized关键字直接对方法加锁, 使得线程安全
 */
public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> objects = new Vector<>();
        objects.add("mouse");
    }

}
