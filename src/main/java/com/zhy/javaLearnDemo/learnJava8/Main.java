package com.zhy.javaLearnDemo.learnJava8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/9/18 19:42
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        Student s5 = new Student(5L, "肖战1", 14, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        // testFilter(students);
        // testMap(students);
        //testDistinct();
        //testDistincts(students);
        //testSort1();
        //testSort2(students);
        //testLimit();
        //testSkip();
        //testReduce();
        testMin(students);
    }

    private static void testMin(List<Student> students) {
        Optional<Student> student = students.stream().min((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println(student.get());
    }

    private static void testReduce() {
        List<String> strings = Arrays.asList("欢", "迎", "你");
        String st = strings.stream().reduce("北京", (a, b) -> a + b);
        System.out.println(st);
    }

    private static void testSkip() {
        Arrays.asList("111","222","333","444").stream().skip(2).forEach(System.out::println);
    }

    //限制返回个数
    private static void testLimit() {
        Arrays.asList("111","222","333","444").stream().limit(2).forEach(System.out::println);
}

    //集合排序
    private static void testSort2(List<Student> students) {
        /*students.stream().sorted(
                (s1,s2)->Integer.compare(s1.getAge(),s2.getAge())
        ).forEach(student -> System.out.println(student));
*/

        students.stream().sorted((s1,s2)->{
            if (s1.getAge()>s2.getAge()){
                return -1;
            }else {
                return 1;
            }
        }).forEach(student -> System.out.println(student));
    }

    //集合排序操作
    private static void testSort1() {
        List<String> strings = Arrays.asList("111","555", "1","222","6666","2222" ,"333");
        strings.stream().sorted().forEach(System.out::println);
    }

    //去重操作 对象集合去重操作... 需要重写对象的equals 和 hash方法
    private static void testDistincts(List<Student> students) {
        //List<Student> collect = students.stream().filter(distinctByKey(b -> b.getAddress())).collect(Collectors.toList());
        List<Student> collect = students.stream().distinct().collect(Collectors.toList());
        collect.forEach(student -> System.out.println(student));
    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    //去重操作 基本数据类型
    private static void testDistinct() {
        List<String> strings = Arrays.asList("111", "111", "222", "223", "333", "444");
        Stream<String> distinct = strings.stream().distinct();
        distinct.forEach(System.out::println);
    }

    //筛选
    private static void testMap(List<Student> students) {
        List<String> addressList = students.stream().map(s -> "住址:" + s.getAddress()).collect(Collectors.toList());
        addressList.forEach(s-> System.out.println(s));
    }
    //获取某个值的集合
    private static List<Student> testFilter(List<Student> students) {

        List<Student> collect = students.stream().filter(s -> "浙江".equals(s.getAddress())).collect(Collectors.toList());
        collect.forEach(System.out::println);
        return collect;

    }





}
