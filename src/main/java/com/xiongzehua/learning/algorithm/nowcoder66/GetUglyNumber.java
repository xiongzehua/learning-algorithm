package com.xiongzehua.learning.algorithm.nowcoder66;

import java.util.ArrayList;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by xiongzehua on 2019/3/6.
 */
public class GetUglyNumber {
    public int getUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(50);
        list.add(0); list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        /**
         * ist.get(p) * i恒大于 list.getLast()
         * 目前list.getLast()为5
         * p2 指向第3个元素 3, 3*2 > 5
         * p3 指向第2个元素 2, 2*3 > 5
         * p5 指向第2个元素 2, 2*5 > 5
         */
        int p2 = 3, p3 = 2, p5 = 2;
        for (int i = 5; i < n; i++) {
            int min = Math.min(Math.min(list.get(p2) * 2, list.get(p3) * 3), list.get(p5) * 5);
            if (min == list.get(p2) * 2) p2++;
            if (min == list.get(p3) * 3) p3++;
            if (min == list.get(p5) * 5) p5++;
            list.add(min);
        }
        return list.get(n);
    }
}
