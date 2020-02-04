package com.zhy.javaLearnDemo.threads.class_msb.L10;

import javax.swing.tree.TreeNode;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: T05
 * @Description: ReentrantLock可以指定公平锁
 * @auther: zhy
 * @Date: 2019/10/30 16:55
 * @Version: 1.0
 **/
public class T05 extends Thread {

    private static ReentrantLock lock =  new ReentrantLock(true);//参数为true表示为公平锁,请对比输出结果


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        T05 t1 = new T05();

        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(t1);

        t2.start();
        t3.start();
    }
}
