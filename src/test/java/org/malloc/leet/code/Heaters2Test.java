package org.malloc.leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author malloc
 * @since 2020/6/9
 */
class Heaters2Test {

    private final Heaters2 heaters = new Heaters2();

    @Test
    void findRadius() {
        int radius = heaters.findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30});
        Assertions.assertEquals(13, radius);
    }

    @Test
    void findRadius2() {
        int radius = heaters.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
        Assertions.assertEquals(1, radius);
    }

    @Test
    void findRadius3() {
        int radius = heaters.findRadius(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{2, 9});
        Assertions.assertEquals(3, radius);
    }


    @Test
    void findRadius4() {
        int radius = heaters.findRadius(new int[]{1, 2, 3}, new int[]{2});
        Assertions.assertEquals(1, radius);
    }

    @Test
    void findRadius5() {
        int radius = heaters.findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612});
        Assertions.assertEquals(161834419, radius);
    }
}