package com.zhy.javaLearnDemo.threads.class_msb.L03;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01
 * @Description: 面试题:模拟银行账户
 *                      对业务写方法加锁
 *                      对业务读方法不加锁
 *                      这样行不行
 *
 *              容易产生脏读问题:
 * @auther: zhy
 * @Date: 2019/10/10 16:52
 * @Version: 1.0
 **/
public class Account {
    String name;
    double balance;

    //设置方法
    public synchronized void set(String name,double balance){
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public synchronized double getBalance(String name){
        return this.balance;
    }


    public static void main(String[] args) {
        Account account = new Account();

        new Thread(()->account.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(account.getBalance("zhangsan"));
    }
}
