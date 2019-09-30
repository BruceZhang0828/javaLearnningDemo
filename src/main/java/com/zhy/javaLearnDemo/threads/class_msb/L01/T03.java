package com.zhy.javaLearnDemo.threads.class_msb.L01;

/**
 * @ClassName: T03
 * @Description: 多线程的使用之 Sleep Yield Join
 * @auther: zhy
 * @Date: 2019/9/29 15:07
 * @Version: 1.0
 **/
public class T03 {

    public static void main(String[] args) {
        //testSleep();
        //testYield();
        testJoin();
    }

    static void testSleep(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * @Author zhy
     * @Description
     *      休眠当前线程, 是线程编程可执行状态,以便其他相同优先级的线程有机会执行;
     *      注意: 再次执行调度程序决定的， 可以立刻会再次执行。。。
     *      yield会释放资源锁吗？
     *      yield不会释放资源所,当暂停后,等待调度程序再次调用,走完同步区域代码后才释放锁
     * @Date 15:17 2019/9/29
     * @Param []
     * @return void
    **/
    static void testYield(){
        new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("A" + i);
                if(i%10 == 0) Thread.yield();
            }
        }).start();


        new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("------------B" + i);
                if(i%10 == 0) Thread.yield();
            }
        }).start();
    }


    static void testJoin(){

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);

                try{
                    Thread.sleep(600);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 100; i++) {
                System.out.println("B"+i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();
    }
}
