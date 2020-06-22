package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/22
 */
class StringToIntegerTest {

    private final StringToInteger integer = new StringToInteger();

    @Test
    void myAtoi1() {
        int i = integer.myAtoi("   -42");
        Assertions.assertEquals(-42, i);
    }

    @Test
    void myAtoi2() {
        int i = integer.myAtoi("4193 with words");
        Assertions.assertEquals(4193, i);
    }

    @Test
    void myAtoi3() {
        int i = integer.myAtoi("+-2");
        Assertions.assertEquals(0, i);
    }

    @Test
    void myAtoi4() {
        int i = integer.myAtoi("  -0012a42");
        Assertions.assertEquals(-12, i);
    }

    @Test
    void myAtoi5() {
        int i = integer.myAtoi("   +0 123");
        Assertions.assertEquals(0, i);
    }
}