package com.mouse.java.algorithm;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/20
 * @description
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        for (int i=1;i<11;i++){
            heap.insert(i);
        }
        for (int i=1;i<11;i++){
            heap.deleteMax();
        }
    }

    private int[] heap; // 存放数据
    private int capacity;   // 堆的最大容量
    private int count;  // 堆中目前存放的数据个数

    public Heap(int capacity) {
        this.heap = new int[capacity + 1];    // 数组下标为0的地方不存放元素（这样计算左右子结点的位置的时候，方便表示）
        this.capacity = capacity;
        this.count = 0;
    }

    public void insert(int data) {
        if (count >= capacity) return; // 堆满了
        count++;
        heap[count] = data;
        int i = count;
        while (i / 2 > 0 && heap[i] > heap[i / 2]) {    // 如果子结点的数据比父结点大，就堆化，交换位置
            swap(heap, i, i / 2);    // 交换数据
            i = i / 2;
        }
    }

    // 交换下标a1和下标a2的数据
    private static void swap(int[] heap, int a1, int a2) {
        // 不借助额外的内存空间，来交换两个数
        heap[a1] = heap[a1] ^ heap[a2];
        heap[a2] = heap[a1] ^ heap[a2];
        heap[a1] = heap[a1] ^ heap[a2];
        /**
         * 上面三行代码等价于这几行代码
         * int tmp = heap[a2];
         * heap[a2] = heap[a1];
         * heap[a1] = tmp
         */

    }

    public void deleteMax() {
        if (count == 0) return; // 空堆
        heap[1] = heap[count];
        count--;
        heapify(heap, 1, count);   // 从上往下堆化
    }

    // 堆化
    private static void heapify(int[] heap, int i, int count) {
        while (2 * i <= count) {
            int maxIndex = i;
            if (heap[i] < heap[2 * i]) maxIndex = 2 * i;     // 和左结点比较
            if ((2 * i + 1) <= count && heap[2 * i + 1] > heap[2 * i]) maxIndex = 2 * i + 1;    // 如果右结点更大，则和右结点交换
            if (maxIndex == i) return;  // 如果左右子结点均小于当前结点，就表示不需要堆化了，直接返回
            swap(heap, i, maxIndex);    // 交换数据
            i = maxIndex;
        }
    }

    // 建堆（从上往下建堆）
    public static int[] buildHeap(int[] a) {
        int length = a.length;
        // 数组a的下标为0的地方不存放元素
        for (int i = length / 2; i >= 1; i--) {  // 叶子结点不需要堆化，因为叶子结点下面是没有左右子结点的，无法向下堆化
            heapify(a, i, length - 1);
        }
        return a;
    }

    // 排序
    public static void sort(int[] a) {
        a = buildHeap(a);   // 先建堆
        int i = a.length - 1;
        while (i > 1) {
            swap(a, 1, i);  // 将第一个数放到数组后面
            i--;
            heapify(a, 1, i);  // 堆化
        }
    }

}
