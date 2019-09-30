package com.zhy.javaLearnDemo.threads.juc.lock;

/**
 * @ClassName: LockDemo
 * @Description: 死锁的实现
 * @auther: zhy
 * @Date: 2019/9/23 9:14
 * @Version: 1.0
 **/

class Lock1 implements Runnable{

    @Override
    public void run() {
        synchronized (LockDemo.l1){
            System.out.println("1:我获得了第一个锁");
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (LockDemo.l2){
                System.out.println("1:我获得了第二个锁");
            }
        }
    }
}



class Lock2 implements Runnable{

    @Override
    public void run() {
        synchronized (LockDemo.l2){
            System.out.println("2:我获得了第一个锁");
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (LockDemo.l1){
                System.out.println("2:我获得了第二个锁");
            }
        }
    }
}

public class LockDemo {
    public static String l1 = "lock1";
    public static String l2 = "lock2";

    public static void main(String[] args) {
        Thread t1 = new Thread(new Lock1());
        Thread t2 = new Thread(new Lock2());
        t1.start();
        t2.start();
    }
}
