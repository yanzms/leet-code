package org.stray.leet.code;

import java.util.BitSet;

/**
 * The type Heaters 2.
 *
 * @author yanzm
 * @since 2020 /6/9
 */
public class Heaters2 {
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
        BitSet housesBit = new BitSet();
        for (int house : houses) {
            leftHouse = Math.min(leftHouse, house);
            rightHouse = Math.max(rightHouse, house);
            housesBit.set(house);
        }
        int leftHeater = MAX_NUM, rightHeater = 0;
        BitSet heatersBit = new BitSet();
        for (int heater : heaters) {
            leftHeater = Math.min(leftHeater, heater);
            rightHeater = Math.max(rightHeater, heater);
            heatersBit.set(heater);
        }
        int radius = 0;
        for (int heater : heaters) {
            int pre = heatersBit.previousSetBit(heater - 1);
            if (pre == -1) {
                continue;
            }
            if (!this.checkSetRange(housesBit, pre, heater)) {
                continue;
            }
            int center = (heater + pre) / 2;
            boolean isE = ((heater + pre) & 1) > 0;
            int preHouse = housesBit.previousSetBit(isE ? center - 1 : center);
            int nextHouse = housesBit.nextSetBit(isE ? center + 1 : center);
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

    private boolean checkSetRange(BitSet bitSet, int from, int to) {
        for (int i = from; i < to; ++i) {
            if (bitSet.get(i)) {
                return true;
            }
        }
        return false;
    }
}
