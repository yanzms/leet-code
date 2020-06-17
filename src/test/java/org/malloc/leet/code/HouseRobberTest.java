package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/17
 */
class HouseRobberTest {

    private final HouseRobber robber = new HouseRobber();

    @Test
    void rob1() {
        int r = robber.rob(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(4, r);
    }

    @Test
    void rob2() {
        int r = robber.rob(new int[]{2, 7, 9, 3, 1});
        Assertions.assertEquals(12, r);
    }

    @Test
    void rob3() {
        int r = robber.rob(new int[]{2, 1, 1, 2});
        Assertions.assertEquals(4, r);
    }
}