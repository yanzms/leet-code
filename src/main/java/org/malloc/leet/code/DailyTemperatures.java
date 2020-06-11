package org.malloc.leet.code;

/**
 * 739
 * The type Daily temperatures.
 *
 * @author malloc
 * @since 2020 /6/11
 */
public class DailyTemperatures {
    /**
     * Daily temperatures int [ ].
     *
     * @param T the t
     * @return the int [ ]
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            result[i] = 0;
            for (int j = i + 1; j < T.length; ++j) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
