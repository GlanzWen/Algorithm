package com.glanz.java.everyday;

public class CountPairsOfConnectableServersInaWeightedTreeNetwork {

    public static void main(String[] args) {
        int[][] edges = {{0,6,3},{6,5,3},{0,3,1},{3,2,7},{3,1,6},{3,4,2}};
        int[] res = countPairsOfConnectableServers(edges, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        } //2,0,0,0,0,0,2
    }

    public static int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int len = edges.length;
        int[] res = new int[len + 1];

        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = 0;

            int mid = i;
            int sum = 0;

            while (mid >= 1) {
                sum += edges[mid - 1][2];
                if (sum % signalSpeed == 0) ++left;
                else break;
                --mid;
            }
            sum = 0;
            mid = i;

            while (mid < len) {
                sum += edges[mid][2];
                if (sum % signalSpeed == 0) ++right;
                else break;
                ++mid;
            }
            res[i] = left * right;
        }
//
        return  res;
    }


}
