package com.zhangshuaibiao.demo.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangsb29016
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @create 2020/6/28 19:19
 * @desc
 */
public class ReentrantLockDemo {
    private static final Lock lock = new ReentrantLock();
}
