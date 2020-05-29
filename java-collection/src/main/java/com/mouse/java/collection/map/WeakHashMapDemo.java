package com.mouse.java.collection.map;

import java.util.WeakHashMap;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-02-03
 * @description WeakHashMap
 * Entry 实现了 WeakReference 本身就是弱引用
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap<String,String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("mouse","mouse");
    }

}
