package com.zhy.javaLearnDemo.threads.class_msb.L02;

/**
 * @ClassName: T01
 * @Description: synchronized是对某个对象进行加锁
 * @auther: zhy
 * @Date: 2019/9/30 11:05
 * @Version: 1.0
 **/
public class T01 {

    private int count = 10;

    private Object o = new Object();

    public void m(){
        /*synchronized (o){
            count --;
            System.out.println(Thread.currentThread().getName()+"count = "+count);
        }*/
        count --;
        System.out.println(Thread.currentThread().getName()+"count = "+count);
    }


    public static void main(String[] args) {
        T01 t01 = new T01();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                t01.m();
            }).start();
        }
    }
}
