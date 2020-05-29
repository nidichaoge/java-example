package com.mouse.java.collection.map;

import java.util.HashMap;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description HashMap 1.8 底层基于数组 链表 红黑树实现 1.8以前基于数组和链表实现 线程不安全 性能好
 * 负载因子0.75f
 *
 * 位运算
 * hash()方法 高16位和低16位进行的异或运算 计算桶位置进行异或运算等
 *
 * 链表转红黑树 以提高检索效率
 *
 * 扩容
 * 在扩容过程中，树化要满足两个条件：
 * 1 链表长度大于等于 TREEIFY_THRESHOLD
 * 2 桶数组容量大于等于 MIN_TREEIFY_CAPACITY
 *
 * 被 transient 所修饰 table 变量
 * 桶数组 table 被申明为 transient。HashMap 并没有使用默认的序列化机制，而是通过实现readObject/writeObject两个方法自定义了序列化的内容。
 * 序列化 talbe 存在着两个问题：
 * 1 table 多数情况下是无法被存满的，序列化未使用的部分，浪费空间
 * 2 同一个键值对在不同 JVM 下，所处的桶位置可能是不同的，在不同的 JVM 下反序列化 table 可能会发生错误。
 * 如果键没有覆写 hashCode 方法，计算 hash 时最终调用 Object 中的 hashCode 方法。但 Object 中的 hashCode 方法是 native 型的，不同的 JVM 下，可能会有不同的实现，产生的 hash 可能也是不一样的。
 * 也就是说同一个键在不同平台下可能会产生不同的 hash，此时再对在同一个 table 继续操作，就会出现问题
 *
 * 线程不安全
 * 1.在jdk1.7中，在多线程环境下，扩容时会造成环形链或数据丢失。
 * 2.在jdk1.8中，在多线程环境下，会发生数据覆盖的情况。 put的时候导致的多线程数据不一致
 * 另外一个比较明显的线程不安全的问题是HashMap的get操作可能因为resize而引起死循环（cpu100%）
 *
 * https://www.jianshu.com/p/e2f75c8cce01
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mouse","mouse");
    }

}
