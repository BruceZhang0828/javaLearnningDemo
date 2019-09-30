package com.zhy.javaLearnDemo.threads.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: ConditionDemoSignal
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/9/27 16:32
 * @Version: 1.0
 **/
public class ConditionDemoSignal implements Runnable{

    private Lock lock;

    private Condition condition;

    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        System.out.println("开始 -ConditionDemoSignal");
        try {
            lock.lock();
            condition.signal();
            System.out.println("结束 - ConditionDemoSignal");
        }finally {
            lock.unlock();
        }
    }
}
