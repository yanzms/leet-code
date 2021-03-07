package org.malloc.leet.code.algorithm.nextgreaterelementii;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 维护单调栈下标
 *
 * @author malloc
 * @since 2021/3/7
 */
public class Solution3 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
