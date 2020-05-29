package com.mouse.java.collection.list;

import java.util.ArrayList;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description ArrayList 底层基于Object类型的数组实现 线程不安全 支持快速随机访问 性能好
 * 扩容
 * 1 使用无参构造函数,第一次添加元素 此时minCapacity等于默认的容量（10）那么最后数组的容量会从0扩容成10
 * 而后的数组扩容才是按照当前容量的1.5倍进行扩容
 * 2 使用自定义初始容量构造方法创建并且指定初始容量为0,第一次添加元素 此时minCapacity等于1 那么最后数组的容量会从0变成1
 * 这边可以看到一个严重的问题，一旦我们执行了初始容量为0，那么根据下面的算法前四次扩容每次都 +1，在第5次添加数据进行扩容的时候才是按照当前容量的1.5倍进行扩容。
 * 3 当扩容量（newCapacity）大于ArrayList数组定义的最大值后会调用hugeCapacity来进行判断。
 * 如果minCapacity已经大于Integer的最大值（溢出为负数）那么抛出OutOfMemoryError（内存溢出）
 * 否则的话根据与MAX_ARRAY_SIZE的比较情况确定是返回Integer最大值还是MAX_ARRAY_SIZE。
 * 这边也可以看到ArrayList允许的最大容量就是Integer的最大值（-2的31次方~2的31次方减1）
 * <p>
 * 优化
 * new ArrayList<>(); 时不直接分配容量为10的数组 而是在第一次添加元素时才会进行0到10的扩容
 * <p>
 * 快速报错机制
 * Java容器的快速报错机制ConcurrentModificationException
 * Java容器有一种保护机制，能够防止多个进程同时修改同一个容器的内容。如果在迭代遍历某个容器的过程中，另一个进程介入其中，并且插入，删除或修改此容器的某个对象，就会立刻抛出ConcurrentModificationException。
 * 迭代遍历指的就是使用迭代器Iterator(ListIterator)或者forEach语法，实际上一个类要使用forEach就必须实现Iterable接口并且重写它的Iterator方法所以forEach本质上还是使用Iterator。
 * <p>
 * 线程不安全
 * 多线程并发对同一ArrayList对象进行add() 操作时 可能丢失一些数据
 * add()方法在第4步Arrays.copyOf的时候，返回一个新的数组对象
 * 因此：当有线程t1、t2同时进入grow方法，两个线程都会执行Arrays.copyOf方法，返回2个不同的elementData对象，
 * 假如，t1先返回，t2后返回，那么List.elementData == t1.elementData，
 * 然后t2也返回后，这时List.elementData == t2.elementData
 * 这时，t2.elementData就把t1.elementData数据给覆盖了。导致t1.elementData被丢失
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        /**
         * 1 使用无参构造函数,第一次添加元素 此时minCapacity等于默认的容量（10）那么最后数组的容量会从0扩容成10
         */
        ArrayList<String> objects = new ArrayList<>();
        objects.add("mouse");

        /**
         * 2 使用自定义初始容量构造方法创建并且指定初始容量为,第一次添加元素 此时minCapacity等于1 那么最后数组的容量会从0变成1
         */
        ArrayList<Object> objects1 = new ArrayList<>(0);
        objects1.add("mouse");
    }

}
