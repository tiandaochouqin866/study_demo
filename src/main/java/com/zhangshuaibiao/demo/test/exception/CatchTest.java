package com.zhangshuaibiao.demo.test.exception;

/**
 * @author zhangsb29016
 * @create 2020/8/6 20:02
 * @desctry catch是直接处理，处理完成之后程序继续往下执行，throw则是将异常抛给它的上一级处理，程序便不往下执行了。
 * 本题的catch语句块里面，打印完1之后，又抛出了一个RuntimeException，程序并没有处理它，而是直接抛出，
 * 因此执行完finally语句块之后，程序终止了
 * <p>
 * 首先执行try，遇到算术异常，抛出，执行catch，打印1，然后抛出RuntimeException，缓存异常，执行finally，打印2，然后抛出RuntimeException。
 * 如果catch中没有抛出RuntimeException，则执行结果为123。
 */
public class CatchTest {
    public static void main(String[] args) {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }
}
