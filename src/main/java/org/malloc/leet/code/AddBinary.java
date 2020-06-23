package org.malloc.leet.code;

/**
 * 67
 *
 * @author malloc
 * @since 2020/6/23
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int len = Math.max(aLen, bLen) + 1;
        char[] sum = new char[len];
        sum[len - 1] = '0';

        for (int i = aLen - 1, j = bLen - 1, k = len - 1; i >= 0 || j >= 0; --i, --j, --k) {
            char iChar = (i >= 0 ? a.charAt(i) : '0');
            char jChar = (j >= 0 ? b.charAt(j) : '0');
            char[] temp = this.add(iChar, jChar);
            char[] tempPlus = this.add(temp[1], sum[k]);
            char[] tempPlusPlus = this.add(temp[0], tempPlus[0]);
            sum[k] = tempPlus[1];
            sum[k - 1] = tempPlusPlus[1];
        }
        if (sum[0] != '1') {
            return new String(sum, 1, len - 1);
        }
        return new String(sum);
    }

    private char[] add(char a, char b) {
        if (a == '0' && b == '0') {
            return new char[]{'0', '0'};
        }
        if (a == '1' && b == '1') {
            return new char[]{'1', '0'};
        }
        return new char[]{'0', '1'};
    }
}
