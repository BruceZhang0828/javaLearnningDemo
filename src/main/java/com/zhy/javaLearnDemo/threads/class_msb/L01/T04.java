package com.zhy.javaLearnDemo.threads.class_msb.L01;

/**
 * @ClassName: T04
 * @Description: states of the thread
 * @auther: zhy
 * @Date: 2019/9/30 10:52
 * @Version: 1.0
 **/
public class T04 extends Thread{

    @Override
    public void run() {
        System.out.println(this.getState());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        Thread t04 = new T04();
        System.out.println(t04.getState());

        t04.start();

        try {
            t04.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t04.getState());
    }


}
