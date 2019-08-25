package com.xiongzehua.learning.algorithm.api;

import com.xiongzehua.learning.algorithm.baseDataStructure.DiGraphBFS;
import com.xiongzehua.learning.algorithm.baseDataStructure.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by xiongzehua on 2019/4/2.
 */
class Person {
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class ApiTest {

    @Test
    public void test1() {
        Person p = new Person();
        p.name = "gmm";
        replace(p);
        System.out.println(p);
    }


    public void replace(Person person) {
        person = null;
    }

    @Test
    public void test2() {
        String a = "   aaa   bbb  ";
        System.out.println(Arrays.toString(a.toCharArray()));
    }

    @Test
    public void test3() {
        char a = '\n';
        System.out.println(a + 0);
    }

    @Test
    public void test4() {
        int i = -1;
        System.out.println(Integer.toUnsignedString(i, 2));
    }

    public void replace4() {

    }
}
