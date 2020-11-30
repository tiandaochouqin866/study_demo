package com.zhangshuaibiao.demo.test.concurrence;

/**
 * @author zhangsb29016
 * @create 2020/11/30 19:56
 * @desc
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        //通过匿名内部类覆盖ThreadLocal的intialValue()方法，指定初始值
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "]sn[" + sn.getNextNum() + "]");

            }
        }


    }


}
