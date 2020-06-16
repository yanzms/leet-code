package org.malloc.leet.code;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        List<Integer> list = IntStream.of(nums).boxed().sorted().collect(Collectors.toList());
        Map<List<Integer>, Integer> listMap = new ConcurrentHashMap<>();
        return this.deleteAndEarnLong(list, listMap);
    }

    public int deleteAndEarnLong(List<Integer> list, Map<List<Integer>, Integer> listMap) {
        Set<Integer> set = new HashSet<>();
        List<CompletableFuture<Integer>> cfsList = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < list.size(); ++i) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
                int finalI = i;
                CompletableFuture<Integer> cfs = CompletableFuture.supplyAsync(() -> {
                    Pair<List<Integer>, Integer> array = copySkip(list, finalI);
                    return list.get(finalI) + deleteAndEarnShort(array.getL(), listMap,
                            list.get(finalI),
                            finalI + 1 < list.size() && list.get(finalI).equals(list.get(finalI + 1)));
                }, executorService);
                cfsList.add(cfs);
            }
        }
        return cfsList.stream().map(CompletableFuture::join).max(Integer::compareTo).orElse(0);
    }

    public int deleteAndEarnShort(List<Integer> list, Map<List<Integer>, Integer> listMap, int lastDel, boolean nextIsSame) {
        if (listMap.containsKey(list)) {
            return listMap.get(list);
        }
        if (nextIsSame) {
            for (int i = 0; i < list.size(); ++i) {
                if (lastDel == list.get(i)) {
                    List<Integer> array = copySkip(list, i).getL();
                    return list.get(i) + deleteAndEarnShort(array, listMap,
                            list.get(i),
                            i + 1 < list.size() && list.get(i).equals(list.get(i + 1)));
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (!map.containsKey(list.get(i))) {
                Pair<List<Integer>, Integer> array = copySkip(list, i);
                if (array.getR() < cnt) {
                    continue;
                }
                int r = list.get(i) + deleteAndEarnShort(array.getL(), listMap,
                        list.get(i),
                        i + 1 < list.size() && list.get(i).equals(list.get(i + 1)));
                map.put(list.get(i), r);
                cnt = Math.max(cnt, r);
            }
        }
        listMap.put(list, cnt);
        return cnt;
    }

    private Pair<List<Integer>, Integer> copySkip(List<Integer> nums, int index) {
        List<Integer> list = new ArrayList<>(nums.size());
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == index || nums.get(i) == nums.get(index) - 1 || nums.get(i) == nums.get(index) + 1) {
                continue;
            }
            list.add(nums.get(i));
            sum += nums.get(i);
        }
        return new Pair<>(list, sum);
    }

    static class Pair<L, R> {
        private L l;
        private R r;

        public Pair(L l, R r) {
            this.l = l;
            this.r = r;
        }

        public L getL() {
            return l;
        }

        public void setL(L l) {
            this.l = l;
        }

        public R getR() {
            return r;
        }

        public void setR(R r) {
            this.r = r;
        }
    }
}
