package com.zhy.javaLearnDemo.threads.class_msb.L04;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T02
 * @Description: 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，
 *               再次申请的时候仍然会得到该对象的锁.
 *               这里是继承中可能发生的情形,子类中调用父类的同步方法
 * @auther: zhy
 * @Date: 2019/10/10 17:26
 * @Version: 1.0
 **/
public class T02 {
    synchronized void m1() {
        System.out.println("m1 start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }


    public static void main(String[] args) {
        new Tt02().m1();
    }
}

class Tt02 extends T02{

    @Override
    synchronized void m1() {
        System.out.println("child m start");
        super.m1();
        System.out.println("child m end");
    }
}
