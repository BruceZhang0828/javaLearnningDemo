package com.zhy.javaLearnDemo.threads.class_msb.L01;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01
 * @Description: 什么是多线程
 * @auther: zhy
 * @Date: 2019/9/29 14:45
 * @Version: 1.0
 **/
public class T01 {

   private static class T1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("T1");
            }
        }
    }


    public static void main(String[] args) {
        new T1().start();

        for (int i = 0; i < 10; i++) {

            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("main");
        }
    }
}
