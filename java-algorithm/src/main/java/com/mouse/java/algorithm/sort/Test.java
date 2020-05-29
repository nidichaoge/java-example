package com.mouse.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/9
 * @description
 */
public class Test {

    private static final int[] array = {2,4,1,5,3,7,6,2,9,0};

    private static final int[] array2 = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
//        Sort sort = new BubbleSort();
        Sort sort = new QuickSort();
//        Sort sort = new HeapSort();
//        Sort sort = new SelectionSort();
//        Sort sort = new InsertionSort();
        sort.sort(array);
        print();
//
//        sort.sort(array2);

    }

    private static void print(){
        System.out.println(Arrays.toString(array));
    }
}
