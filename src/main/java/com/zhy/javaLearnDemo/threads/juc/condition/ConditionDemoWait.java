package com.zhy.javaLearnDemo.threads.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: ConditionDemoWait
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/9/27 16:27
 * @Version: 1.0
 **/
public class ConditionDemoWait implements Runnable{



    private Lock lock;

    private Condition condition;

    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("开始 -conditionDemoWait");

        try{
            lock.lock();
            condition.await();
            System.out.println("结束 -ConditionDemoWait");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
