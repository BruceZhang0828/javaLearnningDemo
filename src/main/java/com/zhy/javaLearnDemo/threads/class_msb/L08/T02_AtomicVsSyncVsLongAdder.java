package com.zhy.javaLearnDemo.threads.class_msb.L08;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName: T02_AtomicVsSyncVsLongAdder
 * @Description: 累加的三种操作的对比
 *               速度排名:
 *               LongAdder
 *                AtomicLong
 *                sync
 *                但是这里只是针对这一种累加的情况,实际开发中应该结合直接业务进行测试;
 * @auther: zhy
 * @Date: 2019/10/17 9:22
 * @Version: 1.0
 **/
public class T02_AtomicVsSyncVsLongAdder {

    static long count2 = 0L;

    static AtomicLong count1 = new AtomicLong(0L);

    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count1.incrementAndGet();
                }
            });
        }

        long start = System.currentTimeMillis();

        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();

        long end = System.currentTimeMillis();

        System.out.println("atomic: "+(end - start));

        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (lock){
                            count2++;
                        }
                    }
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();
        end = System.currentTimeMillis();

        System.out.println("sync: "+(end - start));

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            });
        }


        start = System.currentTimeMillis();

        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();
        end = System.currentTimeMillis();

        System.out.println("LongAdder: "+(end - start));

    }

}
