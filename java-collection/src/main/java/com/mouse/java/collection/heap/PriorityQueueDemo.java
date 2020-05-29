package com.mouse.java.collection.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/12
 * @description
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10);
        for (int i = 1;i<100;i++){
            priorityQueue.add(i);
        }
        System.out.println(priorityQueue.size());
        System.out.println(Arrays.toString(priorityQueue.toArray()));
    }
}
