package com.zhy.javaLearnDemo.threads.class_msb.L10;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: T06
 * @Description: CountDownLatch测试
 * @auther: zhy
 * @Date: 2019/10/30 17:18
 * @Version: 1.0
 **/
public class T06 {


    public static void main(String[] args) {
        //usingCountDownLatch();
        usingJoin();
    }



    private static void usingCountDownLatch(){
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result+=j;
                }
                System.out.println(result);
                latch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");
    }



    private static void usingJoin(){
        Thread[] threads = new Thread[100];
        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result+=j;
                }
                System.out.println(result);
            });
        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }


        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }
}
