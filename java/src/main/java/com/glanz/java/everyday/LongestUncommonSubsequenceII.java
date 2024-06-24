package com.glanz.java.everyday;

public class LongestUncommonSubsequenceII {
    public static void main(String[] args) {

    }

    public int findLUSlength(String[] strs) {

        int len = strs.length;
        int res = -1;

        for (int i = 0; i < len; ++i) {

            boolean check = true;

            for (int j = 0; j < len; ++j) {

                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }

            }

            if (check) {
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }



    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}
