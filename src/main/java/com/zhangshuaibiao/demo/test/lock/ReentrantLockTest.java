package com.zhangshuaibiao.demo.test.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangsb29016
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @create 2020/6/10 14:33
 * @desc
 */
public class ReentrantLockTest {
    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();

        }
    }

    static class ThreadDemo implements Runnable{
        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁的线程"+id);
                lock.unlock();
            }
        }


    }
}
