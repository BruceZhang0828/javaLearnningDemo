package com.zhy.javaLearnDemo.threads.class_msb.L02;

/**
 * @ClassName: T03
 * @Description: 同步和非同步方法可以同时进行调用
 * @auther: zhy
 * @Date: 2019/10/10 16:36
 * @Version: 1.0
 **/
public class T03 {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"m1 start ... ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end ... ");
    }


    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m2");
    }


    public static void main(String[] args) {
        T03 t = new T03();

        new Thread(t::m1).start();
        new Thread(t::m2).start();
    }
}
