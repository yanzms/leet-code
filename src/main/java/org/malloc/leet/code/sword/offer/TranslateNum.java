package org.malloc.leet.code.sword.offer;

/**
 * 面试题46. 把数字翻译成字符串
 *
 * @author malloc
 * @since 2020/6/9
 */
public class TranslateNum {


    public int translateNum(int num) {
        int fst = num % 10;
        int numAfterFst = num / 10;
        if (numAfterFst == 0) {
            return 1;
        }
        int sec = numAfterFst % 10;
        int secFst = sec * 10 + fst;
        if (sec > 0 && secFst <= 25) {
            int numAfterSecFst = numAfterFst / 10;
            if (numAfterSecFst == 0) {
                return this.translateNum(numAfterFst) + 1;
            }
            return this.translateNum(numAfterSecFst) + this.translateNum(numAfterFst);
        }
        return this.translateNum(numAfterFst);
    }
}
