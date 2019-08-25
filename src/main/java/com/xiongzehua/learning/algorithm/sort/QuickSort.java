package com.xiongzehua.learning.algorithm.sort;

/**
 * Created by xiongzehua on 2019/3/7.
 */
public class QuickSort {
    public void quickSort(int[] nums) {
        quickSortRecursion(nums, 0, nums.length - 1);
    }
    private void quickSortRecursion(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSortRecursion(nums, left, pivot - 1);
            quickSortRecursion(nums, pivot + 1, right);
        }
    }
    // left 作为 pivotTemp
    // right先走，最后 pivotTemp和 right交换
    private int partition(int[] nums, int left, int right) {
        int pivotTemp = left;
        while (left < right) {
            while (left < right && nums[right] >= nums[pivotTemp]) right--;
            while (left < right && nums[left] <= nums[pivotTemp]) left++;
            swap(nums, left, right);
        } // 循环结束时， right <= left
        swap(nums, pivotTemp, right); // right 才是真正pivot的位置
        return right;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
