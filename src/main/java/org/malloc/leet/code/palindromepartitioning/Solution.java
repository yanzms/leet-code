package org.malloc.leet.code.palindromepartitioning;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author malloc
 * @since 2021/3/7
 */
public class Solution {
    public List<List<String>> partition(String s) {
        final char[] chars = s.toCharArray();
        final int length = chars.length;
        if (length == 1) {
            return Collections.singletonList(Collections.singletonList(s));
        }
        HashMap<String, List<List<String>>> dp = new HashMap<>();
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = length - 1; i >= 0; --i) {
            final char[] copyIToLen = Arrays.copyOfRange(chars, i, length);
            final String copyIToLenStr = new String(copyIToLen);
            List<List<String>> iList = new ArrayList<>();
            for (int j = i; j < length; ++j) {
                final char[] copyIToJ = Arrays.copyOfRange(chars, i, j + 1);
                final String copyIToJStr = new String(copyIToJ);
                final Boolean aBoolean = map.computeIfAbsent(copyIToJStr, this::isPalindrome);
                if (aBoolean) {
                    final char[] copyJToLen = Arrays.copyOfRange(chars, j + 1, length);
                    final String copyJToLenStr = new String(copyJToLen);
                    final List<List<String>> lists = dp.get(copyJToLenStr);
                    if (lists == null) {
                        iList.add(Collections.singletonList(copyIToJStr));
                    } else {
                        final List<List<String>> collect = lists.stream()
                                .map(p -> {
                                    List<String> tmpList = new ArrayList<>();
                                    tmpList.add(copyIToJStr);
                                    tmpList.addAll(p);
                                    return tmpList;
                                })
                                .collect(Collectors.toList());
                        iList.addAll(collect);
                    }
                }
            }
            dp.put(copyIToLenStr, iList);
        }
        return dp.get(s);
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}
