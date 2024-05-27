package com.glanz.java.everyday;

import java.util.Arrays;

public class FindMissingObservations {

    public static void main(String[] args) {

    }


    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int totalSum = mean * (n + len);

        for (int roll : rolls) {
            totalSum -= roll;
        }

        if (totalSum < n || totalSum > n * 6) {
            return new int[]{};
        }

        int div = totalSum / n;
        int mod = totalSum % n;
        int[] res = new int[n];

        Arrays.fill(res, div);

        for (int i = 0; i < mod; i++) {
            ++res[i];
        }
        return res;
     }
}
