package com.zhy.javaLearnDemo.threads.class_msb.L10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: T02
 * @Description: 使用reentrantlock可以完成同样的功能
 *               需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 *               使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * @auther: zhy
 * @Date: 2019/10/18 12:30
 * @Version: 1.0
 **/
public class T02 {

    Lock lock = new ReentrantLock();


    void m1(){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i==2)m2();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    void m2(){
        try {
            lock.lock();
            System.out.println("m2...");
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        T02 t02 = new T02();

        new Thread(t02::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       new Thread(t02::m2).start();


    }
}
