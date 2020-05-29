package com.mouse.java.algorithm;

import java.util.Arrays;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/13
 * @description
 */
public class Test {

    private static final int[] array = new int[6];
    private static final int[] array2 = new int[3];
    public static void main(String[] args) {
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;

        array2[0] = 1;
        array2[1] = 7;
        array2[2] = 8;
        System.out.println(Arrays.toString(array));
        merge(array,3,array2,3);
        System.out.println(Arrays.toString(array));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 链表二等分点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode{
         ListNode next;
    }
}
