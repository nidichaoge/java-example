package com.mouse.java.algorithm.topn;

import java.util.Arrays;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
public class MaxHeap {


    private int[] heap;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity) {
        heap = new int[capacity + 1];
        size = 0;
    }

    public MaxHeap(int[] num) {
        this(num, num.length * 2);
    }

    public MaxHeap(int[] num, int capacity) {
        this(capacity + 1);
        if (num.length > capacity) {
            try {
                throw new Exception("capacity不能小于数组的长度！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 1, len = num.length; i <= len; ++i) {
            ++size;
            heap[i] = num[i - 1];
        }
        adjustment(); // 调整堆
    }

    /**
     * 调整堆
     */
    private void adjustment() {
        for (int i = size / 2; i >= 1; --i) {
            int temp = heap[i];
            int max_index = i * 2;
            while (max_index <= size) {
                if (max_index < size && heap[max_index] < heap[max_index + 1])
                    ++max_index;
                if (temp > heap[max_index]) break;
                heap[max_index / 2] = heap[max_index];
                max_index *= 2;
            }
            heap[max_index / 2] = temp;
        }
    }

    public void insert(int element) {
        if (size == 0) { // 堆为空，直接插入0位置
            heap[1] = element;
            ++size;
            return;
        } else if (size >= heap.length - 1) { // 容量已满，扩容
            resize();
        }
        int index = ++size;
        while (index != 1 && element > heap[index / 2]) {
            heap[index] = heap[index / 2];
            index /= 2;
        }
        heap[index] = element;
    }

    public void resize() {
        heap = Arrays.copyOf(heap, heap.length + heap.length / 2);
    }

    /**
     * 删除最大值
     *
     * @return
     */
    public int removeMax() {
        int max = heap[1];
        heap[1] = heap[size--];
//        adjustment();
        int temp = heap[1];
        int current_index = 1 * 2;
        while (current_index <= size) {
            if (current_index < size && heap[current_index] < heap[current_index + 1]) {
                current_index++;
            }
            if (heap[current_index] < temp) break;
            heap[current_index / 2] = heap[current_index];
            current_index *= 2;
        }
        heap[current_index / 2] = temp;
        return max;
    }

    public void print() {
        for (int i = 1; i <= size; ++i) {
            System.out.print(heap[i] + " ");
        }
    }

    public int topN(int n) {
        int res = 0;
        for (int i = size; i > 0; --i) {
            if (--n == 0) {
                res = heap[1];
                break;
            }
            removeMax();
        }
        return res;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(12);
        maxHeap.insert(14);
        maxHeap.insert(11);
        maxHeap.insert(110);
        maxHeap.insert(411);
        maxHeap.insert(11);
        maxHeap.topN(2);
        maxHeap.print();
        System.out.println();
        System.out.println("============");
//        MaxHeap maxHeap1 = new MaxHeap(new int[]{12, 14, 11, 110, 411, 11});
//        maxHeap1.removeMax();
//        maxHeap1.print();
    }


}
