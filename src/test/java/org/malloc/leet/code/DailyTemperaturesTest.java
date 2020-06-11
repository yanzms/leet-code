package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/11
 */
class DailyTemperaturesTest {

    private final DailyTemperatures temperatures = new DailyTemperatures();

    @Test
    void dailyTemperatures() {
        int[] result = temperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Assertions.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, result);
    }
}