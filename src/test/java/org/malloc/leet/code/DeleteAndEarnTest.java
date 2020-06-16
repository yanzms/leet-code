package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/11
 */
class DeleteAndEarnTest {

    private final DeleteAndEarn earn = new DeleteAndEarn();

    @Test
    void deleteAndEarn1() {
        int result = earn.deleteAndEarn(new int[]{3, 4, 2});
        Assertions.assertEquals(6, result);
    }

    @Test
    void deleteAndEarn2() {
        int result = earn.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
        Assertions.assertEquals(9, result);
    }

    @Test
    void deleteAndEarn3() {
        int result = earn.deleteAndEarn(new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5});
        Assertions.assertEquals(138, result);
    }

    @Test
    void deleteAndEarn4() {
        int result = earn.deleteAndEarn(new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5});
        Assertions.assertEquals(138, result);
    }

    @Test
    void deleteAndEarn5() {
        int result = earn.deleteAndEarn(new int[]{10, 8, 4, 2, 1, 3, 4, 8, 2, 9, 10, 4, 8, 5, 9, 1, 5, 1, 6, 8, 1, 1, 6, 7, 8, 9, 1, 7, 6, 8, 4, 5, 4, 1, 5, 9, 8, 6, 10, 6, 4, 3, 8, 4, 10, 8, 8, 10, 6, 4, 4, 4, 9, 6, 9, 10, 7, 1, 5, 3, 4, 4, 8, 1, 1, 2, 1, 4, 1, 1, 4, 9, 4, 7, 1, 5, 1, 10, 3, 5, 10, 3, 10, 2, 1, 10, 4, 1, 1, 4, 1, 2, 10, 9, 7, 10, 1, 2, 7, 5});
        Assertions.assertEquals(338, result);
    }

    @Test
    void deleteAndEarn6() {
        int result = earn.deleteAndEarn(new int[]{12, 32, 93, 17, 100, 72, 40, 71, 37, 92, 58, 34, 29, 78, 11, 84, 77, 90, 92, 35, 12, 5, 27, 92, 91, 23, 65, 91, 85, 14, 42, 28, 80, 85, 38, 71, 62, 82, 66, 3, 33, 33, 55, 60, 48, 78, 63, 11, 20, 51, 78, 42, 37, 21, 100, 13, 60, 57, 91, 53, 49, 15, 45, 19, 51, 2, 96, 22, 32, 2, 46, 62, 58, 11, 29, 6, 74, 38, 70, 97, 4, 22, 76, 19, 1, 90, 63, 55, 64, 44, 90, 51, 36, 16, 65, 95, 64, 59, 53, 93});
        Assertions.assertEquals(3451, result);
    }

    @Test
    void deleteAndEarn7() {
        int result = earn.deleteAndEarn(new int[]{12, 32, 93, 17, 100, 72, 40, 71, 37, 92, 58, 34, 29, 78, 11, 84, 77, 90, 92, 35, 12, 5, 27, 92, 91, 23, 65, 91, 85, 14, 42, 28, 80, 85, 38, 71, 62});
        Assertions.assertEquals(1447, result);
    }
}