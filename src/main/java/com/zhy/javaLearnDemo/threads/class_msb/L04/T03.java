package com.zhy.javaLearnDemo.threads.class_msb.L04;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T03
 * @Description: 程序员执行过程中,如果出现异常,默认情况锁会被释放
 *              所以,在并发处理的过程中,有异常要多加小心,不然可能会发生不一致的情况;
 *              在第一个线程中抛出异常,其他线程就会进入同步代码块区,有可能会访问到异常产生时的数据
 *              因此要非常小心的处理同步业务逻辑中的异常
 * @auther: zhy
 * @Date: 2019/10/11 9:39
 * @Version: 1.0
 **/
public class T03 {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        for (; ; ) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (count == 5) {
                    int i = 1 / 0; //此处抛出异常,锁将被释放,要想不被释放,可以在这里进行catch,然后让循环继续
                    System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        T03 t = new T03();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };

        new Thread(r,"t1").start();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r,"t2").start();
    }
}
