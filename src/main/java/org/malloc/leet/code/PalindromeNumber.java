package org.malloc.leet.code;

/**
 * The type Palindrome number.
 *
 * @author malloc
 * @since 2020 /6/10
 */
public class PalindromeNumber {
    /**
     * Is palindrome boolean.
     *
     * @param x the x
     * @return the boolean
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int y = 0;
        int z = x;
        while (z > 0) {
            y = 10 * y + z % 10;
            z = z / 10;
        }
        return y == x;
    }
}
