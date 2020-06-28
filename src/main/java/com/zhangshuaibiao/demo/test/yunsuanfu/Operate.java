package com.zhangshuaibiao.demo.test.yunsuanfu;

import org.springframework.util.StringUtils;

/**
 * @author zhangshuaibiao
 * @create 2020/3/11 16:06
 * @desc
 */
public class Operate {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);
        num = num << 1;
        System.out.println(num);
        num = num >> 1;
        System.out.println(num);
        
        String s = null;
        System.out.println(s.equals("s"));
    }
}
