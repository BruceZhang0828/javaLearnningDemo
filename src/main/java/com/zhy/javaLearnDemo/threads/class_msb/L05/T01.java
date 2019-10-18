package com.zhy.javaLearnDemo.threads.class_msb.L05;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01
 * @Description: volatile 关键字,使一个变量在多个线程之间可见;
 *              A B线程都用到了一个变量,java默认是A线程中保留一份copy,这样如果B线程修改了该变量,
 *              则A线程未必知道,使用volatile关键字,会让所有线程都会读到变量的修改值;
 *
 *              下面的代码中,running是存在于堆内存中的t对象中,
 *              当前线程t1开始运行的时候,会把running值从内存读到t1线程的工作区,在运行过程中直接使用这个copy,并不会每次都去;
 *              读取堆内存,这样,当主线程修改running的值之后,t1线程感知不到,不会停止运行;
 *
 *              使用volatile,将会强制所有线程都去堆内存中读取running的值;
 *
 *              可以阅读这篇文章进行更深入的理解
 *              http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 *
 *              volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 *
 *
 * @auther: zhy
 * @Date: 2019/10/12 8:59
 * @Version: 1.0
 **/
public class T01 {
    volatile boolean running = true;

    void m(){
        System.out.println("m start");
        while(running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T01 t = new T01();

        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
        t.running = false;
    }
}
