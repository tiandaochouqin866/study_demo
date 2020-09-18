package com.zhangshuaibiao.demo.test.enums;

/**
 * @author zhangsb29016
 * @create 2020/9/17 14:30
 * @desc
 */
public class SingleTest {
    public static void main(String[] args) {
        EnumTest instance1 = EnumTest.INSTANCE;
        EnumTest instance2 = EnumTest.INSTANCE;

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
