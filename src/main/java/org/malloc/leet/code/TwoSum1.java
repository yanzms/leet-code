package org.malloc.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 1
 *
 * @author malloc
 * @since 2020/6/18
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int key = target - nums[i];
            if (!map.containsKey(key)) {
                continue;
            }
            int j = map.get(key);
            if (i == j) {
                continue;
            }
            return new int[]{i, j};
        }
        return new int[]{};
    }
}
