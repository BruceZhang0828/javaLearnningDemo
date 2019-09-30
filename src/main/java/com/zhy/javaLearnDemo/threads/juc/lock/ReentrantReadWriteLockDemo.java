package com.zhy.javaLearnDemo.threads.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReentrantReadWriteLockDemo
 * @Description: 读写锁:维护了一对锁,一个写锁,一个读锁;适用场景是多读少写的
 *               读锁和读锁:共享的
 *               读锁和写锁:不共享的
 *               写锁和写锁:不共享的
 * @auther: zhy
 * @Date: 2019/9/23 11:32
 * @Version: 1.0
 **/
public class ReentrantReadWriteLockDemo {
    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock readLock = rwl.readLock();
    static Lock writeLock = rwl.writeLock();

    public static final Object get(String key){
        System.out.println("开始读数据");
        readLock.lock();
        try {
            return cacheMap.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static final Object put(String key,Object value){
        writeLock.lock();
        System.out.println("开始写数据");
        try{
            return cacheMap.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
}
