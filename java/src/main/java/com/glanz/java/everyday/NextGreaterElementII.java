package com.glanz.java.everyday;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] res = nextGreaterElements1(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    /*
    * ±©Á¦
    * */
    public static int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        Arrays.fill(res, -1);

        for (int i = 0; i < len; i++) {
            int flag = 0;
            for (int k = i + 1; k < len; k++) {
                if (nums[k] > nums[i]) {
                    res[i] = nums[k];
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        res[i] = nums[j];
                        break;
                    }
                }
            }

        }
        return res;
    }

    /*
    *µ¥µ÷Õ»
    * */
    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

}
