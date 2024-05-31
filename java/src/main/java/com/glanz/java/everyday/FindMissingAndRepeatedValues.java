package com.glanz.java.everyday;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {

    }

    /*
     * Violence
     * */
    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int len = grid.length;
        int[] compareArray = new int[len * len + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ++compareArray[grid[i][j]];
            }
        }
        int[] res = new int[2];
        for (int i = 1; i < len * len + 1; i++) {
            if (compareArray[i] == 2) res[0] = i;
            if (compareArray[i] == 0) res[1] = i;
        }
        return res;
    }

    /*
     * Bitwise operations
     * */
    public int[] findMissingAndRepeatedValues2(int[][] grid) {
        int n = grid.length;
        int xorAll = 0;
        for (int[] row : grid) {
            for (int x : row) {
                xorAll ^= x;
            }
        }
        xorAll ^= n % 2 > 0 ? 1 : n * n;
        int shift = Integer.numberOfTrailingZeros(xorAll);

        int[] ans = new int[2];
        for (int x = 1; x <= n * n; x++) {
            ans[x >> shift & 1] ^= x;
        }
        for (int[] row : grid) {
            for (int x : row) {
                ans[x >> shift & 1] ^= x;
            }
        }

        for (int[] row : grid) {
            for (int x : row) {
                if (x == ans[0]) {
                    return ans;
                }
            }
        }
        return new int[]{ans[1], ans[0]};
    }

    /*
     * Math
     * compute a - b
     * compute a + b
     * */
    public int[] findMissingAndRepeatedValues3(int[][] grid) {
        int len = grid.length;
        int spare = len * len;
        int d1 = -spare * (spare + 1) / 2;
        long d2 = (long) -spare * (spare + 1) * (spare * 2 + 1) / 6;

        for (int[] row : grid) {
            for (int x : row) {
                d1 += x;
                d2 += x * x;
            }
        }
        int d = (int) (d2 / d1);
        return new int[]{(d + d1) / 2, (d - d1) / 2};
    }
}
