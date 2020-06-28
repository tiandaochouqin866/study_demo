package com.zhangshuaibiao.demo.test.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangsb29016
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @create 2020/6/10 16:44
 * @desc
 */
public class ConditionTest {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        lock.lock();
        new Thread(new SingleThread()).start();
        System.out.println("主线程等待通知");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("主线程恢复运行");
    }

    static class SingleThread implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                condition.signal();
                System.out.println("子线程通知");
            } finally {
                lock.unlock();
            }
        }
    }
}
