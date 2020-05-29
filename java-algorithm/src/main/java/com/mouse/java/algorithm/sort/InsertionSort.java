package com.mouse.java.algorithm.sort;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/27
 * @description
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] array) {
        int preIndex, current;
        for (int i = 1; i < array.length; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

}
