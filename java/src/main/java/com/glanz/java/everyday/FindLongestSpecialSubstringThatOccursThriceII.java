package com.glanz.java.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindLongestSpecialSubstringThatOccursThriceII {
    public static void main(String[] args) {

    }

    public int maximumLength(String s) {
        char[] chs = s.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());

        int SameCount = 0;

        for (int i = 0; i < chs.length; i++) {
            SameCount++;
            if (i + 1 == chs.length || chs[i] != chs[i + 1]) {
                groups[chs[i] - 'a'].add(SameCount); // 统计连续字符长度
                SameCount = 0;
            }
        }

        int res = 0;
        for (List<Integer> list : groups) {
            if (list.isEmpty()) continue;
            list.sort(Collections.reverseOrder());
            list.add(0);
            list.add(0); // 假设还有两个空串
            res = Math.max(res, Math.max(list.get(0) - 2, Math.max(Math.min(list.get(0) - 1, list.get(1)), list.get(2))));
        }

        return res > 0 ? res : -1;
    }
}
