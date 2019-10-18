package com.zhy.javaLearnDemo.threads.class_msb.L10;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01
 * @Description: reentrantlock用于替代synchronized
 *               本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行;
 *               这里是复习synchronized最原始的语义
 * @auther: zhy
 * @Date: 2019/10/18 11:00
 * @Version: 1.0
 **/
public class T01 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);
            if (i==2)m2();
        }
    }

    synchronized void m2(){
        System.out.println("m2...");
    }


    public static void main(String[] args) {
        T01 t01 = new T01();

        new Thread(t01::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t01::m2).start();
    }
}
