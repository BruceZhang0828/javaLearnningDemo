package com.zhy.javaLearnDemo.threads.class_msb.L08;

import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName: T03_SyncVsLongAdder
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/10/17 10:01
 * @Version: 1.0
 **/
public class T03_SyncVsLongAdder {
    static long count1 = 0L;
    static LongAdder count2 = new LongAdder();


    public static void main(String[] args) {
        Thread[] threads = new Thread[500];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count2.increment();
                }
            });
        }

        long start = System.currentTimeMillis();
        for (Thread t:threads){t.start();}
        for (Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("longadder: "+count2.longValue()+"time:"+(end - start));


        Object lock = new Object();
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (lock){
                            count1++;
                        }
                    }
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread t:threads){t.start();}
        for (Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();

        System.out.println("sync: "+count1+"time:"+(end - start));
    }
}
