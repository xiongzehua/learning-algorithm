package com.xiongzehua.learning.algorithm.dynamicProgramming;

import org.junit.Test;

/**
 * Created by xiongzehua on 2019/1/26.
 */
public class MinCoinsTest {
    @Test
    public void test() {
        int[] arr1 = { 100, 20, 5, 10, 2, 50, 1 };
        int aim1 = 17019;
        System.out.println(MinCoins.answer(arr1, aim1));
        System.out.println(MinCoins.work(arr1, aim1));

        int[] arr2 = { 10, 100, 2, 5, 5, 5, 10, 1, 1, 1, 2, 100 };
        int aim2 = 223;
        System.out.println(MinCoins.answer(arr2, aim2));
        System.out.println(MinCoins.work(arr2, aim2));

        int[] arr3 = {5, 2, 3};
        int aim3 = 20;
        System.out.println(MinCoins.answer(arr3, aim3));
        System.out.println(MinCoins.work(arr3, aim3));
    }
}
