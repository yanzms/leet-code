package org.malloc.leet.code.algorithm.nextgreaterelementii;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 维护单调栈内容
 *
 * @author malloc
 * @since 2021/3/6
 */
public class Solution2 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 2 * len - 1; i >= 0; --i) {
            int value = nums[i % len];
            while (!stack.isEmpty() && stack.peek() <= value) {
                stack.pop();
            }
            if (i < len) {
                ret[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(value);
        }
        return ret;
    }
}
