package org.malloc.leet.code;

/**
 * 475. Heaters
 *
 * @author yanzm
 * @since 2020 /6/4
 */
public class Heaters1 {
    private static final int MAX_NUM = 1000000000;

    /**
     * Find radius int.
     *
     * @param houses  the houses
     * @param heaters the heaters
     * @return the int
     */
    public int findRadius(int[] houses, int[] heaters) {
        int leftHouse = MAX_NUM, rightHouse = 0;
        boolean[] housesBit = new boolean[MAX_NUM];
        for (int house : houses) {
            leftHouse = Math.min(leftHouse, house);
            rightHouse = Math.max(rightHouse, house);
            housesBit[house] = true;
        }
        int leftHeater = MAX_NUM, rightHeater = 0;
        boolean[] heatersBit = new boolean[MAX_NUM];
        for (int heater : heaters) {
            leftHeater = Math.min(leftHeater, heater);
            rightHeater = Math.max(rightHeater, heater);
            heatersBit[heater] = true;
        }
        int radius = 0;
        for (int heater : heaters) {
            int pre = previousSetBit(heatersBit, heater - 1);
            if (pre == -1) {
                continue;
            }
            if (!this.checkSetRange(housesBit, pre, heater)) {
                continue;
            }
            int center = (heater + pre) / 2;
            boolean isE = ((heater + pre) & 1) > 0;
            int preHouse = previousSetBit(housesBit, isE ? center - 1 : center);
            int nextHouse = nextSetBit(housesBit, isE ? center + 1 : center);
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


    private int previousSetBit(boolean[] bits, int from) {
        for (int i = from; i >= 0; --i) {
            if (bits[i]) {
                return i;
            }
        }
        return -1;
    }

    private int nextSetBit(boolean[] bits, int from) {
        for (int i = from; i < bits.length; ++i) {
            if (bits[i]) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkSetRange(boolean[] bits, int from, int to) {
        for (int i = from; i < to; ++i) {
            if (bits[i]) {
                return true;
            }
        }
        return false;
    }
}
