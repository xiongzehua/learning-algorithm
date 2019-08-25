package com.xiongzehua.learning.algorithm.homework.huawei2;


/**
 * abc def acd123 44234tjg abd 123 abcdef 123456789012345678901234567890123456789012345678901234567890123 EDFG SDFG ABC DEF cccc dd asdfas 234abc35 765rgfh4sd 1231
 * == aga'-= ad--s a*b=1 87&&^ ==
 * bca efd 23acd1 234tjg44 bda 231 efabcd 123456789012345678901234567890123456789012345678901231234567890 FGED FGSD BCA EFD cccc dd asasdf 4abc3523 765rgfh4sd 3112
 * 123456789012345678901234567890123456789012345678901231234567890 231 234tjg44 23acd1 3112 4abc3523 765rgfh4sd BCA EFD FGED FGSD asasdf bca bda cccc dd efabcd efd
 *
 *
 *
 * abc def acd123 44234tjg abd 123 abcdef 123456789012345678901234567890123456789012345678901234567890123 EDFG SDFG ABC DEF cccc dd asdfas 234abc35 765rgfh4sd 1231
 * == aga'-= ad--s a*b=1 87&&^ ==
 * bca efd 23acd1 234tjg44 bda 231 efabcd 123456789012345678901234567890123456789012345678901231234567890 FGED FGSD BCA EFD cccc dd asasdf 4abc3523 765rgfh4sd 3112
 * 123456789012345678901234567890123456789012345678901231234567890 231 234tjg44 23acd1 3112 4abc3523 765rgfh4sd BCA EFD FGED FGSD asasdf bca bda cccc dd efabcd efd
 *
 *
 * abc abc def acd123 44234tjg abd 123 abcdef 123456789012345678901234567890123456789012345678901234567890123 EDFG SDFG ABC DEF cccc dd asdfas 234abc35 765rgfh4sd 1231
 * == == aga'-= ad--s a*b=1 87&&^ ==
 * bca bca efd 23acd1 234tjg44 bda 231 efabcd 123456789012345678901234567890123456789012345678901231234567890 FGED FGSD BCA EFD cccc dd asasdf 4abc3523 765rgfh4sd 3112
 * 123456789012345678901234567890123456789012345678901231234567890 123456789012345678901234567890123456789012345678901231234567890 231 234tjg44 23acd1 3112 4abc3523 765rgfh4sd BCA EFD FGED FGSD asasdf bca bda cccc dd efabcd efd
 *
 *
 * Created by xiongzehua on 2019/4/2.
 */
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        while (in.hasNextLine()) {
            String str = in.nextLine().trim();
            if ("xzh".equals(str))
                break;
            list.add(str);
        }
        HashSet<String> set = new HashSet<>();
        LinkedList<String> vertifiedList = new LinkedList<>();
        LinkedList<String> unvertifiedList = new LinkedList<>();
        LinkedList<String> left10List = new LinkedList<>();
        LinkedList<String> orderedList = new LinkedList<>();

        for (String s : list) {
            if (vertify(s)) {
                if (!set.contains(s)) {
                    vertifiedList.add(s);
                    set.add(s);
                }
            }
            else
                unvertifiedList.add(s);
        }

        for (String s : vertifiedList) {
            String str = left10(s);
            left10List.add(str);
            orderedList.add(str);
        }

        Collections.sort(orderedList);

        for (String s : vertifiedList) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : unvertifiedList) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : left10List) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : orderedList) {
            System.out.print(s + " ");
        }
        System.out.println();

    }

    public static boolean vertify(String str) {
        boolean ok = true;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean is_a_z = chars[i] >= 'a' && chars[i] <= 'z';
            boolean is_A_Z = chars[i] >= 'A' && chars[i] <= 'Z';
            boolean is_0_9 = chars[i] >= '0' && chars[i] <= '9';
            if (!is_0_9 && !is_A_Z && !is_a_z)
                return false;
        }
        return ok;
    }

    public static String left10(String str) {
        char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[left10Index(i, chars.length)] = chars[i];
        }
        return String.valueOf(newChars);
    }

    public static int left10Index(int oldIndex, int length) {
        int newIndex = oldIndex - 10;
        while (newIndex < 0) {
            newIndex = newIndex + length;
        }
        return newIndex;
    }
}

class MyUtil {
    public static int[] toIntArgs(String[] args) {
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.valueOf(args[i]);
        }
        return intArgs;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static int lowerBound(int[] nums, int target) {
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


