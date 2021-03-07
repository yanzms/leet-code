package org.malloc.leet.code.algorithm.nextgreaterelementii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2021/3/7
 */
class Solution2Test {

    private static final int[][] dataIn = new int[][]{
            new int[]{1, 2, 3, 4, 5},
            new int[]{1, 8, -1, -100, -1, 222, 1111111, -111111},
            new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4},
    };

    private static final int[][] dataOut = new int[][]{
            new int[]{2, 3, 4, 5, -1},
            new int[]{8, 222, 222, -1, 222, 1111111, -1, 1},
            new int[]{2, 4, 2, 2, 4, 4, 1, 4, -1, 4, -1},
    };

    @Test
    void nextGreaterElements() {
        Solution2 solution = new Solution2();
        for (int i = 0; i < dataIn.length; ++i) {
            final int[] result = solution.nextGreaterElements(dataIn[i]);
            Assertions.assertArrayEquals(dataOut[i], result);
        }
    }
}