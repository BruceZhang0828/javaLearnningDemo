package com.zhy.javaLearnDemo.threads.juc.condition;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ConditionDemoTest
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/9/29 11:03
 * @Version: 1.0
 **/
public class ConditionDemoTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            try {
                lock.lock();
                condition.await(); //保证字母线进行输出
                for (int i = 0; i < aI.length; i++) {
                    System.out.print(aI[i]);
                    condition.signal();//唤醒其他线程
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

                lock.unlock();
            }
        },"t1").start();


        new Thread(()->{
            lock.lock();
            try {
                for (int i = 0; i < aC.length; i++) {
                    System.out.print(aC[i]);
                    condition.signal();//唤醒其他线程
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

                lock.unlock();
            }
            //condition.signalAll();
        },"t2").start();
    }

}
