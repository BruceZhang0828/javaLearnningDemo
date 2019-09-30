package com.zhy.javaLearnDemo.threads.class_msb.L02;

/**
 * @ClassName: T02
 * @Description: synchronized是锁定的对象
 * @auther: zhy
 * @Date: 2019/9/30 11:12
 * @Version: 1.0
 **/
public class T02 {
    private int count = 10;

    public void m(){
        synchronized (this){
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
