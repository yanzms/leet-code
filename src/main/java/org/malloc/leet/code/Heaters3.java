package org.malloc.leet.code;

import java.util.Arrays;

/**
 * The type Heaters 3.
 *
 * @author yanzm
 * @since 2020 /6/9
 */
public class Heaters3 {
    private static final int MAX_NUM = 1000000000;

    /**
     * Find radius int.
     *
     * @param houses  the houses
     * @param heaters the heaters
     * @return the int
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int leftHouse = MAX_NUM, rightHouse = 0;
        for (int house : houses) {
            leftHouse = Math.min(leftHouse, house);
            rightHouse = Math.max(rightHouse, house);
        }
        int leftHeater = MAX_NUM, rightHeater = 0;
        for (int heater : heaters) {
            leftHeater = Math.min(leftHeater, heater);
            rightHeater = Math.max(rightHeater, heater);
        }
        int radius = 0;
        for (int heater : heaters) {
            int pre = previousArray(heaters, heater - 1);
            if (pre == -1) {
                continue;
            }
            if (!this.checkArrayRange(houses, pre, heater)) {
                continue;
            }
            int center = (heater + pre) / 2;
            boolean isE = ((heater + pre) & 1) > 0;
            int preHouse = previousArray(houses, isE ? center - 1 : center);
            int nextHouse = nextArray(houses, isE ? center + 1 : center);
            if (preHouse == -1) {
                radius = Math.max(radius, Math.min(nextHouse - pre, heater - nextHouse));
            } else if (nextHouse == -1) {
                radius = Math.max(radius, Math.min(preHouse - pre, heater - preHouse));
            } else {
                radius = Math.max(radius, Math.max(preHouse - pre, heater - nextHouse));
            }
        }
        radius = Math.max(radius, leftHeater - leftHouse);
        radius = Math.max(radius, rightHouse - rightHeater);
        return radius;
    }


    private int previousArray(int[] array, int from) {
        int maxVal = -1;
        for (int value : array) {
            if (value <= from) {
                maxVal = Math.max(maxVal, value);
            }
        }
        return maxVal;
    }

    private int nextArray(int[] array, int from) {
        int minVal = MAX_NUM;
        for (int value : array) {
            if (value >= from) {
                minVal = Math.min(minVal, value);
            }
        }
        return minVal == MAX_NUM ? -1 : minVal;
    }

    private boolean checkArrayRange(int[] array, int from, int to) {
        for (int value : array) {
            if (value >= from && value < to) {
                return true;
            }
        }
        return false;
    }
}
