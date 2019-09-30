package com.zhy.javaLearnDemo.learnJava8;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

/**
 * @ClassName: Student
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/9/18 18:52
 * @Version: 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private Long id;

    private String name;

    private int age;

    private String address;

}
