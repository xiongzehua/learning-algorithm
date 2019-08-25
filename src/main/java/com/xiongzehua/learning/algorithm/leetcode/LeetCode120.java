package com.xiongzehua.learning.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiongzehua on 2018/9/18.
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // opt和triangle有相同的结构，并且每个格子保存的是从起点到此格子的最短路径
        List<List<Integer>> opt = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> optRow = new ArrayList<>();
            List<Integer> triangleRow = triangle.get(i);

            if (i == 0) {
                optRow.add(triangleRow.get(0));
            } else {
                for (int j = 0; j < triangleRow.size(); j++) {
                    int value = 0;
                    if (j == 0) {
                        value = opt.get(i - 1).get(j) + triangle.get(i).get(j);
                    } else if (j == triangleRow.size() - 1) {
                        value = opt.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                    } else {
                        value = Math.min(opt.get(i - 1).get(j - 1), opt.get(i - 1).get(j)) +
                                + triangle.get(i).get(j);
                    }
                    optRow.add(value);
                }
            }
            opt.add(optRow);
        }

        List<Integer> lastRow = opt.get(opt.size() - 1);
        lastRow.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return lastRow.get(0);
    }
}
