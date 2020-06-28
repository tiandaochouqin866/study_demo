package com.zhangshuaibiao.demo.test.classes;


import java.lang.reflect.Method;

/**
 * @author zhangsb29016
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @create 2020/6/28 20:52
 * @desc
 */
public class ClassTest {
    public static void main(String[] args) {
        try {
            Class<?>clz = Class.forName("com.zhangshuaibiao.demo.test.classes.RefSon");
            Object obj = clz.newInstance();
            Method refFatherMethod = clz.getMethod("refFatherMethod");
            Method refSonMethod = clz.getDeclaredMethod("refSonMethod");
            refFatherMethod.invoke(obj);
            refSonMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
