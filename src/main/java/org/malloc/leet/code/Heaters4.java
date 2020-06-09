package org.malloc.leet.code;

import java.util.Arrays;

/**
 * @author yanzm
 * @since 2020/6/9
 */
public class Heaters4 {

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
        int houseLen = houses.length;
        int heaterLen = heaters.length;
        int leftHouse = houses[0], rightHouse = houses[houseLen - 1];
        int leftHeater = heaters[0], rightHeater = heaters[heaterLen - 1];
        int radius = 0;
        for (int i = 1; i < heaterLen; ++i) {
            int pre = heaters[i - 1];
            int heater = heaters[i];
            if (!this.checkArrayRange(houses, pre, heater)) {
                continue;
            }
            int center = (heater + pre) / 2;
            boolean isE = ((heater + pre) & 1) > 0;
            int preHouse = previousArray(houses, 0, houseLen - 1, isE ? center - 1 : center);
            int nextHouse = nextArray(houses, 0, houseLen - 1, isE ? center + 1 : center);
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


    private int previousArray(int[] array, int fromIndex, int toIndex, int from) {
        if (fromIndex >= toIndex) {
            if (array[fromIndex] <= from) {
                return array[fromIndex];
            } else {
                return -1;
            }
        }
        int center = (fromIndex + toIndex) / 2;
        if (array[center] > from) {
            if (fromIndex == center) {
                return -1;
            }
            return previousArray(array, fromIndex, center, from);
        } else if (array[center] < from) {
            if (fromIndex == center) {
                if (array[toIndex] < from) {
                    return array[toIndex];
                }
                return array[center];
            }
            return previousArray(array, center, toIndex, from);
        } else {
            return from;
        }
    }

    private int nextArray(int[] array, int fromIndex, int toIndex, int from) {
        if (fromIndex >= toIndex) {
            if (array[fromIndex] >= from) {
                return array[fromIndex];
            } else {
                return -1;
            }
        }
        int center = (fromIndex + toIndex) / 2;
        if (array[center] > from) {
            if (fromIndex == center) {
                return array[center];
            }
            return nextArray(array, fromIndex, center, from);
        } else if (array[center] < from) {
            if (fromIndex == center) {
                if (array[toIndex] > from) {
                    return array[toIndex];
                }
                return -1;
            }
            return nextArray(array, center, toIndex, from);
        } else {
            return from;
        }
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
