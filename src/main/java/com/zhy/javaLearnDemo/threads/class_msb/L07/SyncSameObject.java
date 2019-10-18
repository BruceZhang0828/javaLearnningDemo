package com.zhy.javaLearnDemo.threads.class_msb.L07;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SyncSameObject
 * @Description: 锁定某个对象o,如果的属性发生改变,不影响锁的使用
 *              但是如果o变成另一个对象,则锁定的对象发生改变.
 *              应该避免将锁定对象的引用变成另外的对象
 * @auther: zhy
 * @Date: 2019/10/16 11:07
 * @Version: 1.0
 **/
public class SyncSameObject {
    Object o = new Object();



    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }


    public static void main(String[] args) {
        SyncSameObject t = new SyncSameObject();
        //启动第一个线程
        new Thread(t::m,"t1").start();

        Thread t2 = new Thread(t::m, "t2");
        //t.o = new Object(); //锁对象发生改变,所以t2线程得以执行
        t2.start();
    }
}
