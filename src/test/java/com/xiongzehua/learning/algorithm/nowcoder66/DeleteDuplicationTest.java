package com.xiongzehua.learning.algorithm.nowcoder66;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiongzehua on 2019/3/4.
 */
public class DeleteDuplicationTest {

    @Test
    public void deleteDuplication() {
        ListNode listNode1 = new DeleteDuplication().deleteDuplication(TestCase.list1());
        TestCase.showList(listNode1);
        ListNode listNode2 = new DeleteDuplication().deleteDuplication(TestCase.list2());
        TestCase.showList(listNode2);

    }
}