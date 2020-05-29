package com.mouse.java.algorithm.sort;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/9
 * @description 冒泡排序
 */
public class BubbleSort implements Sort {

    public static void main(String[] args) {

    }

    @Override
    public void sort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) { //控制循环次数
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }

    }

}
