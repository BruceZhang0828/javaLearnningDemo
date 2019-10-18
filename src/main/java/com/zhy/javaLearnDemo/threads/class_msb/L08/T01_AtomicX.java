package com.zhy.javaLearnDemo.threads.class_msb.L08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: T01_AtomicX
 * @Description: 解决++操作更高效的方法,使用AtomX类
 *              AtomX类本身方法都是原子性的,但是不能保证多个方法连续调用是原子性的
 * @auther: zhy
 * @Date: 2019/10/16 11:14
 * @Version: 1.0
 **/
public class T01_AtomicX {
    AtomicInteger count = new AtomicInteger(0);


    void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet(); // count++
        }
    }


    public static void main(String[] args) {
        T01_AtomicX t = new T01_AtomicX();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.stream().forEach(thread->{
            thread.start();
        });

        //保证线程之间的关系 执行完一个线程
        threads.stream().forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(t.count);

    }
}
