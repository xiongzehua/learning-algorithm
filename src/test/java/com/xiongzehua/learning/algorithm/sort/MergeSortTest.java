package com.xiongzehua.learning.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by xiongzehua on 2019/3/7.
 */
public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] nums = {4, 32, 53, 6, 31, 67, 88, 3, 7, 31, 31};
        new MergeSort().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}