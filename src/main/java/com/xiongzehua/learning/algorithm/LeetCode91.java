package com.xiongzehua.learning.algorithm;

import java.util.Arrays;

/**
 * digits数组和opt数组第0位预留，从第一位开始使用
 * 因为递推方程涉及前两项
 *
 * Created by xiongzehua on 2018/9/17.
 */
public class LeetCode91 {
    private int[] opt;
    private int[] digits;
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        digits = new int[chars.length + 1];
        for (int i = 1; i < digits.length; i++) {
            digits[i] = chars[i - 1] - '0';
        }
        opt = new int[chars.length + 1];

        if (digits[1] == 0)
            return 0;

        opt[0] = 1;
        opt[1] = 1;

        for (int i = 2; i < opt.length; i++) {
            //此位和前一位组成起来是否为1-26的数，以便生成一个字母
            boolean merge = (digits[i - 1] * 10 + digits[i]) <= 26 && (digits[i - 1] * 10 + digits[i]) > 0;
            //此位和前一位是否均为1-9，以便生成两个字母
            boolean alone = digits[i - 1] != 0 && digits[i] != 0;
            if (merge && alone)
                opt[i] = opt[i - 2] + opt[i - 1];
            else if (!merge && alone)
                opt[i] = opt[i - 1];
            else if (merge && !alone)
                opt[i] = opt[i - 2];
            else
                return 0;
        }
        return opt[opt.length - 1];
    }
}
