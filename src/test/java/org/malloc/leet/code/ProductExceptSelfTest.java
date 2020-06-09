package org.malloc.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author malloc
 * @since 2020/6/4
 */
class ProductExceptSelfTest {

    private final ProductExceptSelf exceptSelf=new ProductExceptSelf();

    @Test
    void productExceptSelfV2() {
        int[] result = exceptSelf.productExceptSelfV2(new int[]{1, 2, 3, 4});
        assertArrayEquals(result, new int[]{24, 12, 8, 6});
    }
}