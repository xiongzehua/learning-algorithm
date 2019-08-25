package com.xiongzehua.learning.algorithm.baseDataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 为什么使用方法返回测试用例对象，而不是静态成员变量？
 * 这样不同的测试方法使用的都是独立的测试用例对象
 * 若待测试方法里对测试用例进行了修改，不会引发问题
 * Created by xiongzehua on 2019/3/1.
 */
public class TestCase {
    public static HashMap<Integer, List<Integer>> diGraph1() {
        // 算法第四版 P369 图4.2.3 有向有环图
        HashMap<Integer, List<Integer>> diGraph1 = new HashMap<>();
        diGraph1.put(0, Arrays.asList(1, 5));
        diGraph1.put(1, Arrays.asList());
        diGraph1.put(2, Arrays.asList(0, 3));
        diGraph1.put(3, Arrays.asList(2, 5));
        diGraph1.put(4, Arrays.asList(2, 3));
        diGraph1.put(5, Arrays.asList(4));
        diGraph1.put(6, Arrays.asList(0, 4, 9));
        diGraph1.put(7, Arrays.asList(6, 8));
        diGraph1.put(8, Arrays.asList(7, 9));
        diGraph1.put(9, Arrays.asList(10, 11));
        diGraph1.put(10, Arrays.asList(12));
        diGraph1.put(11, Arrays.asList(12));
        diGraph1.put(12, Arrays.asList(9));
        return diGraph1;
    }

    public static HashMap<Integer, List<Integer>> diGraph2() {
        // 算法第四版 P371 图4.2.7
        HashMap<Integer, List<Integer>> diGraph1 = new HashMap<>();
        diGraph1.put(0, Arrays.asList(1, 5, 6));
        diGraph1.put(1, Arrays.asList());
        diGraph1.put(2, Arrays.asList(0, 3));
        diGraph1.put(3, Arrays.asList(5));
        diGraph1.put(4, Arrays.asList());
        diGraph1.put(5, Arrays.asList(4));
        diGraph1.put(6, Arrays.asList(4, 9));
        diGraph1.put(7, Arrays.asList(6));
        diGraph1.put(8, Arrays.asList(7));
        diGraph1.put(9, Arrays.asList(10, 11, 12));
        diGraph1.put(10, Arrays.asList());
        diGraph1.put(11, Arrays.asList(12));
        diGraph1.put(12, Arrays.asList());
        return diGraph1;
    }
}
