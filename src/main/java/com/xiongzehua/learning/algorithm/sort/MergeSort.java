package com.xiongzehua.learning.algorithm.sort;

/**
 * Created by xiongzehua on 2019/3/7.
 */
public class MergeSort {
    private int[] numsHelper;
    public void mergeSort(int[] nums) {
        numsHelper = new int[nums.length];
        sort(nums, 0, nums.length);
    }
    private void sort(int[] nums, int low, int high) {
        if (high - low <= 1) // 一个元素为止
            return;
        int mid = (low + high) / 2;
        sort(nums, low, mid);        // 排序 [low, mid)
        sort(nums, mid, high);       // 排序 [mid, high)
        merge(nums, low, mid, high); // 合并顺序区间 [low, mid)、[mid, high)，
    }
    public void merge(int[] nums, int low, int mid, int high) {
        for (int index = low; index < high; index++) {
            numsHelper[index] = nums[index];
        }
        int i = low;
        int j = mid;
        for (int index = low; index < high; index++) {
            if (!(i < mid)) {
                nums[index] = numsHelper[j++];
                continue;
            }
            if (!(j < high)) {
                nums[index] = numsHelper[i++];
                continue;
            }

            if (numsHelper[i] <= numsHelper[j])
                nums[index] = numsHelper[i++];
            else
                nums[index] = numsHelper[j++];
        }

    }
}
