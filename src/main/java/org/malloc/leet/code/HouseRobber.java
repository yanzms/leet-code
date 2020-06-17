package org.malloc.leet.code;

/**
 * @author malloc
 * @since 2020/6/17
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int preUsing = nums[2] + nums[0], preAvoiding = nums[1], prePreAvoiding = nums[0];
        for (int i = 3; i < nums.length; ++i) {
            int tmpUsing = Math.max(preAvoiding + nums[i], prePreAvoiding + nums[i]);
            prePreAvoiding = preAvoiding;
            preAvoiding = preUsing;
            preUsing = tmpUsing;

        }
        return Math.max(preAvoiding, Math.max(preUsing, prePreAvoiding));
    }
}
