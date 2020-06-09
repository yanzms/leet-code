package org.malloc.leet.code;

/**
 * 238
 * The type Product except self.
 *
 * @author yanzm
 * @since 2020 /6/4
 */
public class ProductExceptSelf {
    /**
     * Product except self int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }
        int[] reverse = new int[length];
        int[] order = new int[length];
        int orderMulNum = 1;
        int reverseMulNum = 1;
        for (int i = 0; i < length; ++i) {
            order[i] = orderMulNum;
            orderMulNum *= nums[i];
            reverse[length - 1 - i] = reverseMulNum;
            reverseMulNum *= nums[length - 1 - i];
        }
        for (int i = 0; i < length; ++i) {
            order[i] *= reverse[i];
        }
        return order;
    }

    public int[] productExceptSelfV2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }
        int[] result = new int[length];
        int orderMulNum = 1;
        int reverseMulNum = 1;
        for (int i = 0; i < length; ++i) {
            if (length - 1 - i < i) {
                result[i] *= orderMulNum;
                result[length - 1 - i] *= reverseMulNum;
            } else if (length - 1 - i == i) {
                result[i] = orderMulNum * reverseMulNum;
            } else {
                result[i] = orderMulNum;
                result[length - 1 - i] = reverseMulNum;
            }
            orderMulNum *= nums[i];
            reverseMulNum *= nums[length - 1 - i];
        }
        return result;
    }
}
