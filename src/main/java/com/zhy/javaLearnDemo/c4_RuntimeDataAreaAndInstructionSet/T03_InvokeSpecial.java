package com.zhy.javaLearnDemo.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @ClassName: T03_InvokeSpecial
 * @Description: TODO 留下注释吧
 * @auther: 搬砖的孟达
 * @Date: 2019/12/11 17:32
 * @Version: 1.0
 **/
public class T03_InvokeSpecial {
    public static void main(String[] args) {
        T03_InvokeSpecial t = new T03_InvokeSpecial();
        t.m();
        t.n();
    }

    public final void m() {}
    private void n() {}
}
