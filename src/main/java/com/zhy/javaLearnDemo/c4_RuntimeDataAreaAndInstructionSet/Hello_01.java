package com.zhy.javaLearnDemo.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @ClassName: Hello_01
 * @Description: 查看字节码指令
 * @auther: 搬砖的孟达
 * @Date: 2019/12/11 14:36
 * @Version: 1.0
 **/
public class Hello_01 {

    public static void main(String[] args) {
        int i = 100;
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
