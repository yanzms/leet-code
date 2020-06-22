package org.malloc.leet.code;

/**
 * @author malloc
 * @since 2020/6/22
 */
public class StringToInteger {

    public int myAtoi(String str) {
        int integer = 0;
        boolean isPositive = true;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                if (integer != 0 || (i > 0 && str.charAt(i - 1) != ' ')) {
                    return this.getInteger(integer, isPositive);
                }
            } else if (str.charAt(i) == '-') {
                if (integer != 0 || (i > 0 && str.charAt(i - 1) != ' ')) {
                    return this.getInteger(integer, isPositive);
                }
                isPositive = false;
            } else if (str.charAt(i) == '+') {
                if (integer != 0 || (i > 0 && str.charAt(i - 1) != ' ')) {
                    return this.getInteger(integer, isPositive);
                }
                isPositive = true;
            } else if (Character.isDigit(str.charAt(i))) {
                int digit = Character.digit(str.charAt(i), 10);
                if (isOverflow(integer, digit)) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    integer = 10 * integer + digit;
                }
            } else {
                return this.getInteger(integer, isPositive);
            }
        }
        return this.getInteger(integer, isPositive);
    }

    private boolean isOverflow(int integer, int digit) {
        if (integer > Integer.MAX_VALUE / 10) {
            return true;
        } else if (integer == Integer.MAX_VALUE / 10 && digit > 7) {
            return true;
        }
        return false;
    }

    private int getInteger(int integer, boolean isPositive) {
        return isPositive ? integer : -1 * integer;
    }
}
