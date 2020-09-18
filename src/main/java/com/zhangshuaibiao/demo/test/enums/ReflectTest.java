package com.zhangshuaibiao.demo.test.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangsb29016
 * @create 2020/9/17 14:39
 * @desc 测试枚举是否可以用反射创建对象
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumTest instance1 = EnumTest.INSTANCE;
        Constructor<EnumTest> declaredConstructor = EnumTest.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        EnumTest instance2 = declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
