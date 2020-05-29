package com.mouse.java.collection.map;

import java.util.Hashtable;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description Hashtable 线程安全 默认初始容量为11
 * synchronized
 */
public class HashtableDemo {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("mouse","mouse");
    }

}
