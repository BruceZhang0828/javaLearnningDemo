package com.zhy.javaLearnDemo.classLoaderTest;

/**
 * @ClassName: ClassLoaderTest
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/11/22 10:27
 * @Version: 1.0
 **/
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoaderTest t = new ClassLoaderTest();
        System.out.println(t.getClass().getClassLoader().getParent().getParent());
        System.out.println(t.getClass().getClassLoader().getParent());
        System.out.println(t.getClass().getClassLoader());
        
    }
}
