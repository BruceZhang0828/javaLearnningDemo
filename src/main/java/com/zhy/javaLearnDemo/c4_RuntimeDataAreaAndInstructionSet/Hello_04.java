package com.zhy.javaLearnDemo.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @ClassName: Hello_04
 * @Description: 递归方法
 * @auther: 搬砖的孟达
 * @Date: 2019/12/11 16:18
 * @Version: 1.0
 **/
public class Hello_04 {
    public static void main(String[] args) {
        Hello_04 h = new Hello_04();
        int m = h.m(3);
    }

    public int m(int n){
        if (n == 1) return 1;

        return n*m(n-1);
    }
}
