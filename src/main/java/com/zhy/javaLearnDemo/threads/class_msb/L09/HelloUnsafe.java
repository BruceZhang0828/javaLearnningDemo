package com.zhy.javaLearnDemo.threads.class_msb.L09;

import sun.misc.Unsafe;

/**
 * @ClassName: HelloUnsafe
 * @Description:
 * @auther: zhy
 * @Date: 2019/10/18 10:49
 * @Version: 1.0
 **/
public class HelloUnsafe {

    static class M{
        private M(){}
        int i = 0;
    }

    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}
