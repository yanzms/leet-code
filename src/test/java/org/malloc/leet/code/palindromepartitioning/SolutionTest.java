package org.malloc.leet.code.palindromepartitioning;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2021/3/8
 */
class SolutionTest {

    @Test
    void partition() {
        final Solution solution = new Solution();
        final List<List<String>> partition = solution.partition("aab");
        System.out.println(partition);
    }
}