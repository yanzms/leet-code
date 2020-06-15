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
}