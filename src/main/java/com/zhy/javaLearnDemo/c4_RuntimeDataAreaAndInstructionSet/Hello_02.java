package com.zhy.javaLearnDemo.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @ClassName: Hello_02
 * @Description: 再上一个代码的基础上添加方法的调用
 * @auther: 搬砖的孟达
 * @Date: 2019/12/11 16:03
 * @Version: 1.0
 **/
public class Hello_02 {

    public static void main(String[] args) {
        Hello_02 h = new Hello_02();
        h.m1();
    }


    public void m1(){
        int i = 200;
    }

    public void m2(int k){
        int i = 300;
    }

    public void add(int a,int b){
        int  c = a+b;
    }

    public void m3(){
        Object o = null;
    }

    public void m4(){
        Object o = new Object();
    }
}
