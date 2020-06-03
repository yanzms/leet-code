package org.stray.leet.code;

/**
 * 152
 * The type Maximum product subarray.
 */
public class MaximumProductSubarray {

    /**
     * Max product int.
     *
     * @param nums the nums
     * @return the int
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] array = new int[len];
        int maxProduct = nums[0];

        for (int i = 0; i < len; ++i) {
            int tempMaxProduct = nums[i];
            int before = array[0];
            for (int j = 1; j <= i; ++j) {
                int tempBefore = array[j];
                array[j] = nums[i] * before;
                tempMaxProduct = Math.max(tempMaxProduct, array[j]);
                before = tempBefore;
            }
            array[0] = nums[i];
            maxProduct = Math.max(maxProduct, tempMaxProduct);
        }

        return maxProduct;
    }
}
