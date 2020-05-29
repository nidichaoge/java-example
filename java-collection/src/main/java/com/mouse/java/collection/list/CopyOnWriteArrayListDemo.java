package com.mouse.java.collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description CopyOnWriteArrayList 底层基于Object类型的数组实现 线程安全 支持快速随机访问 性能相对ArrayList和Vector来说可以
 * 写时复制思想 ReentrantLock volatile
 * <p>
 * 写时复制思想
 * 当有新元素添加到CopyOnWriteArrayList时，先将原有数组的元素拷贝到新数组中，然后在新的数组中做写操作，写完之后，再将原来的数组引用（volatile 修饰的数组引用）指向新数组。
 * CopyOnWriteArrayList的整个add操作都是在锁的保护下进行的。
 * 这里的问题在于 频繁的进行修改操作会使得频繁的创建数组和复制数组元素，使得性能低下
 * <p>
 * CopyOnWriteArrayList的“动态数组”机制：
 * 它内部有个“volatile数组”(array)来保持数据。在“添加(add)/修改(set)/删除(remove)”数据时，都会新建一个数组，并将原数组中的元素拷贝到新数组中，然后在新数组中更新，最后再将“volatile数组”引用指向新数组。
 * 这就是它叫做CopyOnWriteArrayList的原因！CopyOnWriteArrayList就是通过这种方式实现的动态数组；不过正由于它在“添加/修改/删除”数据时，都会新建数组，所以涉及到修改数据的操作，CopyOnWriteArrayList效率很低；但是单单只是进行遍历查找的话，效率比较高。
 * <p>
 * CopyOnWriteArrayList的“线程安全”机制：
 * 是通过 volatile 和 互斥锁 来实现的。
 * CopyOnWriteArrayList是通过“volatile数组”来保存数据的。一个线程读取volatile数组时，总能看到其它线程对该volatile数组最后的写入；就这样，通过volatile提供了“读取到的数据总是最新的”这个机制的保证。
 * CopyOnWriteArrayList通过互斥锁来保护数据。在“添加/修改/删除”数据时，会先“获取互斥锁”，再修改完毕之后，先将“volatile数组”引用指向新数组，然后再“释放互斥锁”；这样，就达到了保护数据的目的。
 * <p>
 * 优点:
 * 1.解决的开发工作中的多线程的并发问题。
 * <p>
 * 缺点:
 * 1.内存占有问题:很明显，两个数组同时驻扎在内存中，如果实际应用中，数据比较多，而且比较大的情况下，占用内存会比较大，针对这个其实可以用ConcurrentHashMap来代替。
 * 可能导致频繁的GC
 * 2.数据一致性:CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。所以如果你希望写入的的数据，马上能读到，请不要使用CopyOnWrite容器
 * 当执行add或remove操作没完成时，get获取的仍然是旧数组的元素
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> objects = new CopyOnWriteArrayList<>();
        objects.add("mouse");
        objects.remove("mouse");
        objects.set(0, "mouse");
    }

}
