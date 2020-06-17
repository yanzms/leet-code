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
     * 转化成不能连续获得点数，类比198.打家劫舍
     *
     * @param nums the nums
     * @return the int
     */
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] cntArray = new int[10001];
        for (int i : nums) {
            cntArray[i]++;
        }
        int[] array = new int[10001];
        for (int i : nums) {
            array[i] = i;
        }
        /*
         * preAvoiding从某种角度来看是不需要Max的
         * 循环中已经使用了Max来获得using
         * 可以看出最大值属性已经被带出来了
         * 所以取不同的值既即可
         * */
        int preUsing = this.getMul(cntArray, array, 0) + this.getMul(cntArray, array, 2),
                preAvoiding = this.getMul(cntArray, array, 1),
                prePreAvoiding = this.getMul(cntArray, array, 0);
        for (int i = 3; i < 10001; ++i) {
            int tempUsing = Math.max(preAvoiding, prePreAvoiding) + this.getMul(cntArray, array, i);
            prePreAvoiding = preAvoiding;
            preAvoiding = preUsing;
            preUsing = tempUsing;
        }
        return Math.max(preUsing, Math.max(preAvoiding, prePreAvoiding));
    }

    private int getMul(int[] cntArray, int[] array, int i) {
        return cntArray[array[i]] * array[i];
    }
}
