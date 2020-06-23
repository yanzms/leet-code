package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/23
 */
class AddBinaryTest {

    private final AddBinary addBinary = new AddBinary();

    @Test
    void addBinary1() {
        Assertions.assertEquals("100", addBinary.addBinary("11", "1"));
    }

    @Test
    void addBinary2() {
        Assertions.assertEquals("10101", addBinary.addBinary("1010", "1011"));
    }

    @Test
    void addBinary3() {
        Assertions.assertEquals("0", addBinary.addBinary("0", "0"));
    }
}