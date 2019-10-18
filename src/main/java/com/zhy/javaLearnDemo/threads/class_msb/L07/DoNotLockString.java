package com.zhy.javaLearnDemo.threads.class_msb.L07;

/**
 * @ClassName: DoNotLockString
 * @Description: 不要一字符串常量作为锁定对象
 *              在下面的例子中,m1和m2其实锁定的同一个对象
 *              在这种情况下发生比较诡异的现象,比如你用到了一个类库,在该类库中锁定了字符串"hello";
 *              但是你读不到源码,所以你在自己的代码中也锁定改了"hello",这时候有可能法神非常诡异的死锁阻塞
 *              因为你的程序和你用到的类库不经意间使用了同一把锁
 * @auther: zhy
 * @Date: 2019/10/16 11:03
 * @Version: 1.0
 **/
public class DoNotLockString {

    String s1 = "lock";
    String s2 = "lock";

    void m1(){
        synchronized (s1){

        }
    }

    void m2(){
        synchronized (s2){
            // 这里m1和m2实际上是用到了一个锁
        }
    }
}
