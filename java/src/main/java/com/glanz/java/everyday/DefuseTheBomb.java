package com.glanz.java.everyday;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int[] res = decrypt(code, 3);
        for (int i = 0; i < code.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    //题有问题
    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];

        if (k == 0) Arrays.fill(res, 0);
        else
            for (int i = 0; i < code.length; i++)
                for (int j = 1; j <= Math.abs(k); j++)
                    res[i] += k > 0 ? code[(i + j) % code.length] : code[(code.length + i - j) % code.length];

        return res;
    }
}
