package com.zhy.javaLearnDemo.threads.class_msb.L06;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: FineCoarseLock
 * @Description:    synchronized优化
 *                  同步代码块中的语句越少越好
 *                  比较m1和m2
 * @auther: zhy
 * @Date: 2019/10/16 10:49
 * @Version: 1.0
 **/
public class FineCoarseLock {
    int count = 0;

    synchronized void m1(){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    void m2(){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //业务逻辑中只有下面这句需要sync,这时不应该给整个方法上锁
        //采用细粒度的锁,可以使线程争用时间变短,从而提高效率
        synchronized (this){
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
