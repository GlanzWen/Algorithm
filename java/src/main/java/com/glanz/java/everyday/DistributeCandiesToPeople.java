package com.glanz.java.everyday;

public class DistributeCandiesToPeople {
    public static void main(String[] args) {
        int[] res = distributeCandies1(10, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


    /*
    * violence
    * */
    public static int[] distributeCandies1(int candies, int num_people) {
        int[] res = new int[num_people];
        int multiplier = 0;
        int index = 0;

        while (candies > 0) {
            if (index == num_people) {
                index = 0;
                multiplier++;
            }
            int curCount = (index + 1) + num_people * multiplier;
            if (curCount < candies) {
                candies -= curCount;
                res[index++] += curCount;
            } else {
                res[index++] += candies;
                candies = 0;
            }
        }
        return res;
    }

    /*
    * cupidity
    * */
    public static int[] distributeCandies2(int candies, int num_people) {
        int[] res = new int[num_people];
        int index = 0;

        while (candies != 0) {
            int curCandies = Math.min(candies, index + 1);
            res[index % num_people] += curCandies;
            candies -= curCandies;
            ++index;
        }

        return res;
    }

    /*
    * The current optimal solution, a series of equal differences
    * */
}
