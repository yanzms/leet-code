package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/10
 */
class PalindromeNumberTest {

    private final PalindromeNumber number = new PalindromeNumber();

    @Test
    void isPalindrome1() {
        Assertions.assertTrue(number.isPalindrome(121));
    }

    @Test
    void isPalindrome2() {
        Assertions.assertFalse(number.isPalindrome(-121));
    }
}