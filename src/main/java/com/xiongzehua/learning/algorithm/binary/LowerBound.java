package com.xiongzehua.learning.algorithm.binary;

/**
 * 查找nums中第一个大于等于target的元素的位置
 * 参考自C++ lower_bound()
 * https://www.zhihu.com/question/36132386/answer/530313852?utm_source=qq&utm_medium=social&utm_oi=33528951603200
 * 补充：
 * lower_bound(): 返回index1,其为不破坏nums次序的前提下，target可插入的第一个位置
 * upper_bound(): 返回index2,其为不破坏nums次序的前提下，target可插入的最后一个位置
 * equal_range(): 返回index1, index2
 *
 * 采用左闭右开的写法划分空间
 *
 * 整个空间划分为三段：
 * [0, low) [low, high) [high, nums.length)
 *
 * 循环不变量 loop invariants：
 * 1. [0, low)里面的元素（若存在）永远小于target
 * 2. [high, nums.length)里面的元素（若存在）永远大于等于target
 * 3. [low, high)不为空
 *
 * 我们现在要做的就是不停把[low, high)里面的元素划为到左右两区间，直至[low, high)为空
 * 此时
 * [0, low)里面的元素（若存在）永远小于target
 * [high, nums.length)里面的元素（若存在）永远大于等于target
 * [low, high)为空
 * 则 high即为第一个大于等于target的元素
 *
 * 划分手法：
 * 若nums[mid] >= target，则将[mid, high)划分到右区间，此时右区间为[mid, nums.length)
 * 即 high = mid
 * 若nums[mid] < target，则将[low, mid]划分到左区间，此时左区间为[0, mid + 1)
 * 即 low = mid + 1
 *
 * Created by xiongzehua on 2019/3/3.
 */
public class LowerBound {
    public int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
