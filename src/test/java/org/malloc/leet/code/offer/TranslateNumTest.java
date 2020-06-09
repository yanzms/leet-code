package org.malloc.leet.code.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yanzm
 * @since 2020/6/9
 */
class TranslateNumTest {

    private final TranslateNum translateNum = new TranslateNum();

    @Test
    void translateNum() {
        int result = translateNum.translateNum(12258);
        Assertions.assertEquals(5, result);
    }

    @Test
    void translateNum2() {
        int result = translateNum.translateNum(506);
        Assertions.assertEquals(1, result);
    }

    @Test
    void translateNum3() {
        int result = translateNum.translateNum(12);
        Assertions.assertEquals(2, result);
    }

    @Test
    void translateNum4() {
        int result = translateNum.translateNum(122);
        Assertions.assertEquals(3, result);
    }
}