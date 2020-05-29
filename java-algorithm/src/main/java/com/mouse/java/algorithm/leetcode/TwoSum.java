package com.mouse.java.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/21
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        //key 值 value 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}