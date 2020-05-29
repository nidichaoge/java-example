package com.mouse.java.algorithm.topn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/12
 * @description
 */
public class Test {

    private static final int[] array = {1,2,3,4,12,3,4,5,1,12,43,21};
    public static void main(String[] args) {
        int[] topn = topn(array, 4);
        System.out.println(Arrays.toString(topn));
    }

    public static int[] topn(int[] arrays,int n){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n);
        for (int i:arrays){
            if (priorityQueue.size()<n){
                priorityQueue.offer(i);
            } else if (priorityQueue.peek() < i){
                priorityQueue.poll();
                priorityQueue.offer(i);
            }
        }

        int[] result = new int[n];
        for (int i = 0;i<n;i++){
             result[i] = priorityQueue.poll();
        }
        return result;
    }
}
