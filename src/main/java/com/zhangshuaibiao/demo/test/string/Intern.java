package com.zhangshuaibiao.demo.test.string;

import org.junit.Test;

import java.util.Random;

/**
 * @author zhangshuaibiao
 * @create 2020/3/17 16:37
 * @desc
 */
public class Intern {

    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];
    public static void main(String[] args) {
        String s = new String(("a"));
        s.intern();
        String s2 = "a";
        System.out.println(s == s2);

        String s3 = new String("a")+ new String("1");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3==s4);


    }

    @Test
    public void intern(){
        String s = new String(("a"));
        s.intern();
        String s2 = "a";
        System.out.println(s == s2);

        String s3 = new String("a")+ new String("a");
        String s4 = "aa";
        s3.intern();
        System.out.println(s3==s4);
    }

    @Test
    public void internTest(){
     Integer[] DB_DATA = new Integer[10];
     Random random = new Random(10 * 10000);
     for (int i = 0; i < DB_DATA.length; i++){
         DB_DATA[i] = random.nextInt();
     }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
           // arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
        }

        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();

        System.out.println(Test1.getInvalidPort());
    }

}
