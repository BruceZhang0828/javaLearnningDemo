package com.zhy.javaLearnDemo.threads.class_msb.L10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: T04
 * @Description: 使用ReentrantLock还可以调用lockInterruptibly方法,可以对线程interruput方法做成响应在一个线程等待锁的过程中可以被打断
 * @auther: zhy
 * @Date: 2019/10/30 16:39
 * @Version: 1.0
 **/
public class T04 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();


        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                //lock.lock();
                lock.lockInterruptibly();//可以对interrupt()方法做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });

        t2.start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断线程2的等待
    }
}
