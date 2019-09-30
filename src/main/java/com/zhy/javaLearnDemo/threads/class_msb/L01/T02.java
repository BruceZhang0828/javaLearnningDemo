package com.zhy.javaLearnDemo.threads.class_msb.L01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: T2
 * @Description: 如何创建线程
 * @auther: zhy
 * @Date: 2019/9/29 14:49
 * @Version: 1.0
 **/
public class T02 {
    static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("Hello T1!");
        }
    }

    static class MyRun implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }


    public static void main(String[] args) {
        new T1().start();

        new Thread(new MyRun()).start();

        new Thread(()->{
            System.out.println("Hello lambda");
        }).start();
    }
}
