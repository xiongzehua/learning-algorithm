package com.xiongzehua.learning.algorithm.binary;

/**
 * Created by xiongzehua on 2019/3/3.
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)
                high = mid;
            else if (nums[mid] == target)
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }
}
