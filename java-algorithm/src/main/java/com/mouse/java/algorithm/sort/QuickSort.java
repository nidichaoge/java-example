package com.mouse.java.algorithm.sort;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/9
 * @description 思想
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSort implements Sort{

    @Override
    public void sort(int[] array) {
//        sort(array,0,array.length-1);
        sort2(array,0,array.length-1);
//        quickSort(array,0,array.length-1);
    }

    public void sort2(int[] array,int left,int right){
        if (left>=right){
            return;
        }
        int i=left,j=right,base = array[left];
        while (i!=j){

            while (array[j]>=base&&i<j){
                j--;
            }
            while (array[i]<=base && i<j){
                i++;
            }
            //交换
            swap(array,i,j);
        }
        swap(array,left,i);
        sort2(array,left,j-1);
        sort2(array,j+1,right);
    }

    private void sort(int[] array,int left,int right){
        //结束条件
        if (left>=right){
            return;
        }

        //基准
        int i = left,j= right,base = array[left];
        while (i<j){
            while (array[right]>=base && left<right){
                right--;
            }
            while (array[left]<=base && left<right){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,right);
        sort(array,left,right-1);
        sort(array,right+1,right);
    }

    public static void quickSort(int[] arr, int low, int high) {
        // low,high 为每次处理数组时的首、尾元素索引

        // 当low==high是表示该序列只有一个元素，不必排序了
        if (low >= high) {
            return;
        }
        // 选出哨兵元素和基准元素。这里左边的哨兵元素也是基准元素
        int i = low, j = high, base = arr[low];
        while (i < j) {
            // 右边哨兵从后向前找
            while (arr[j] >= base && i < j) {
                j--;
            }
            // 左边哨兵从前向后找
            while (arr[i] <= base && i < j) {
                i++;
            }
            swap(arr, i, j); // 交换元素
        }
        swap(arr, low, j); // 基准元素与右哨兵交换

        // 递归调用，排序左子集合和右子集合
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
