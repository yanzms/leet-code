package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/18
 */
class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    void twoSum() {
        int[] r = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertArrayEquals(new int[]{0, 1}, r);
    }
}