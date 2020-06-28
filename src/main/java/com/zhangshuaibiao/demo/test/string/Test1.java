package com.zhangshuaibiao.demo.test.string;

/**
 * @author zhangshuaibiao
 * @create 2020/3/23 20:58
 * @desc
 */
public class Test1 {
    /**
     * 无效端口值
     */
    private final static String INVALID_PORT = "0";

    public static String getInvalidPort() {
        return INVALID_PORT;
    }

    public static void main(String[] args) {
        System.out.println("11111111s1".matches("\\d{10}"));
        System.out.println("0123456789".substring(4,8));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&订单号：：" + "202005071400000000084001824884" + " ,开始授权>>>>>>>>>>>");

        System.out.println(System.currentTimeMillis());

        System.out.println("''公司有限售条件流通股股东网下行权所得标的证券");

    }

}
