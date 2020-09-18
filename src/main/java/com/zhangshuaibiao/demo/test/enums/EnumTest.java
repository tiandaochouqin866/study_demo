package com.zhangshuaibiao.demo.test.enums;

/**
 * @author zhangsb29016
 * @create 2020/9/17 14:28
 * @desc
 */
public enum EnumTest {
    //写一个单例
    INSTANCE;

    public EnumTest getInstance(){
        return INSTANCE;
    }
}
