package com.zhy.javaLearnDemo.threads.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockDemo
 * @Description: ReentrantLock 表示重入锁
 *               重入锁:支持重新进入的锁,如果当前线程t1通过调用lock方法获取了锁之后,
 *               再次调用lock,是不会再阻塞去获取锁的.直接增加重试次数就行了.
 * @auther: zhy
 * @Date: 2019/9/23 9:04
 * @Version: 1.0
 **/
public class ReentrantLockDemo {
    private static int count = 0;
    static Lock lock = new ReentrantLock();
    public static void inc(){
        lock.lock();
        try{
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{ReentrantLockDemo.inc();}).start();
        }

        Thread.sleep(3000);

        System.out.println(ReentrantLockDemo.count);
    }
}
