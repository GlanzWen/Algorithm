package com.glanz.java.binarySearch;

public class SearchInsertPosition {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1, res = len;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }
}
