package com.zhy.javaLearnDemo.threads.class_msb.L02;

/**
 * @ClassName: T02
 * @Description: synchronized是锁定的对象
 * @auther: zhy
 * @Date: 2019/9/30 11:12
 * @Version: 1.0
 **/
public class T02 implements Runnable{
    private int count = 10;

    @Override
    public void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            T02 t = new T02();

            new Thread(t,"t"+i).start();
        }
    }
}
