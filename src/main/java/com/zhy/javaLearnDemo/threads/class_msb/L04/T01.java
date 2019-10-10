package com.zhy.javaLearnDemo.threads.class_msb.L04;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01
 * @Description: 一个同步方法可以调用灵位一个同步方法一个线程已经拥有某个对象,
 *               再次申请的时候任然会得到该对象的锁
 *               也就是说synchronize获得锁是可重入的
 * @auther: zhy
 * @Date: 2019/10/10 17:07
 * @Version: 1.0
 **/
public class T01 {
    synchronized void m1(){
        System.out.println("m1 start...");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();

        System.out.println("m1 end");
    }


    synchronized void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m2");
    }


    public static void main(String[] args) {
        new T01().m1();
    }
}
