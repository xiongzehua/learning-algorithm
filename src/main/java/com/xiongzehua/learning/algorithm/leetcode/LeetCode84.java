package com.xiongzehua.learning.algorithm.leetcode;

import com.xiongzehua.learning.algorithm.util.FirstComparator;

import java.util.Arrays;

/**
 * Created by xiongzehua on 2018/12/13.
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int[] sequenceIndexs = FirstComparator.sequenceAndSmaller(heights);
        int[] reverseIndexs = FirstComparator.reverseAndSmaller(heights);
        System.out.println(Arrays.toString(sequenceIndexs));
        System.out.println(Arrays.toString(reverseIndexs));
        int largest = 0;
        int rectangle = 0;
        for (int i = 0; i < heights.length; i++) {
            rectangle = heights[i] * (sequenceIndexs[i] - reverseIndexs[i] - 1);
            System.out.println(rectangle);
            if (rectangle > largest)
                largest = rectangle;
        }
        return  largest;
    }
}
