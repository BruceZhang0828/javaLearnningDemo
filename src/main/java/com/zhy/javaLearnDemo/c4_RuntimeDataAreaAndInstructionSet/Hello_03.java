package com.zhy.javaLearnDemo.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @ClassName: Hello_03
 * @Description: 在方法中调用方法 有返回值
 * @auther: 搬砖的孟达
 * @Date: 2019/12/11 16:06
 * @Version: 1.0
 **/
public class Hello_03 {
    public static void main(String[] args) {
        Hello_03 h = new Hello_03();
        int i = h.m1();
    }

    public int m1(){
        return 100;
    }
}
