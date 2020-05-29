package com.mouse.java.algorithm.sort;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/27
 * @description
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array) {
        int minIndex;
        for (int i=0;i<array.length;i++){
            minIndex = i;
            for (int j=i+1;j<array.length;j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }

                swap(array,i,minIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
