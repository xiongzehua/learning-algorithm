package com.xiongzehua.learning.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by xiongzehua on 2019/3/7.
 */
public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] nums = {4, 32, 53, 6, 31, 67, 88, 3, 7, 31, 31};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}