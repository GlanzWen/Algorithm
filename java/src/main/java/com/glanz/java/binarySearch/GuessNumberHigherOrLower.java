package com.glanz.java.binarySearch;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int guess (int num) {
        return num;
    }

}
