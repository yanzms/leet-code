package org.malloc.leet.code;

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
        int[] count = new int[10001];
        for (int x : nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k)
            if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        return Math.max(avoid, using);
    }
}
