package com.zhangshuaibiao.demo.test.classloader;

/**
 * @author zhangsb29016
 * @create 2020/8/31 14:37
 * @desc
 */
public class Memory {
    public static void main(String[] args) {
        //获取Memory类的类加载器
        ClassLoader c = Memory.class.getClassLoader();
        System.out.println("当前的类加载器" + c);
        //获取C这个类加载器的父类加载器
        ClassLoader c1 = c.getParent();
        System.out.println("当前类加载器的父类加载器" + c1);
        //获取C1这个类加载器的父类加载器
        ClassLoader c2 = c1.getParent();
        System.out.println("当前类加载器的父类加载器" + c2);

    }
}
