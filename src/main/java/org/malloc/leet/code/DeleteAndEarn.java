package org.malloc.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 740. Delete and Earn
 * <p>
 * The type Delete and earn.
 *
 * @author malloc
 * @since 2020 /6/11
 */
public class DeleteAndEarn {

    /**
     * Delete and earn int.
     *
     * @param nums the nums
     * @return the int
     */
    public int deleteAndEarn(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        Map<List<Integer>, Integer> listMap = new HashMap<>();
        return this.deleteAndEarn(list, listMap);
    }

    public int deleteAndEarn(List<Integer> list, Map<List<Integer>, Integer> listMap) {
        if (listMap.containsKey(list)) {
            return listMap.get(list);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 0);
                List<Integer> array = copySkip(list, i);
                int r = list.get(i) + deleteAndEarn(array, listMap);
                map.put(list.get(i), r);
                cnt = Math.max(cnt, r);
            }
        }
        listMap.put(list, cnt);
        return cnt;
    }

    private List<Integer> copySkip(List<Integer> nums, int index) {
        List<Integer> list = new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); ++i) {
            if (i == index || nums.get(i) == nums.get(index) - 1 || nums.get(i) == nums.get(index) + 1) {
                continue;
            }
            list.add(nums.get(i));
        }
        return list;
    }
}
