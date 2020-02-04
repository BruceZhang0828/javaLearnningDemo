package com.zhy.javaLearnDemo.classLoaderTest;

/**
 * @ClassName: TestExcption
 * @Description: TODO 留下注释吧
 * @auther: 搬砖的孟达
 * @Date: 2019/12/11 13:54
 * @Version: 1.0
 **/
public class TestExcption {
    public static void main(String[] args) {
       // double d = 1/0;

        try{
           double d = 1/0;
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
            StackTraceElement[] stackTrace = e.getStackTrace();
            System.out.println(stackTrace);
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement =  stackTrace[i];
                System.out.println(stackTraceElement.toString());
            }
        }
    }
}
