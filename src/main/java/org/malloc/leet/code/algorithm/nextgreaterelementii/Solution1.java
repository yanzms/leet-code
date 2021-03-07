package org.malloc.leet.code.algorithm.nextgreaterelementii;

import java.util.HashMap;
import java.util.Map;

/**
 * 503
 * 备忘录实现
 *
 * @author malloc
 * @since 2021/3/6
 */
public class Solution1 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        if (len == 0) {
            return result;
        }
        Map<Integer, Integer> dp = new HashMap<>(len);
        int index = getMaxIndex(nums, len);
        result[index] = -1;
        dp.put(nums[index], -1);
        int i = index == 0 ? len - 1 : index - 1;
        while (i != index) {
            int next = i == len - 1 ? 0 : i + 1;
            if (nums[i] < nums[next]) {
                result[i] = nums[next];
            } else if (nums[i] == nums[next]) {
                result[i] = result[next];
            } else {
                result[i] = result[next];
                while (nums[i] >= result[i]) {
                    Integer value = dp.get(result[i]);
                    if (result[i] == nums[index]) {
                        result[i] = -1;
                        break;
                    } else {
                        result[i] = value;
                    }
                }
            }
            dp.put(nums[i], result[i]);
            i = i == 0 ? len - 1 : i - 1;
        }
        return result;
    }

    private int getMaxIndex(int[] nums, int len) {
        int maxIndex = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
