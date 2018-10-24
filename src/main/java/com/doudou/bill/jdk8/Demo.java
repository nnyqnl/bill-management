package com.doudou.bill.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * jdk1.8新特性
 */
public class Demo {
    /**
     * lambda表达式和函数式接口
     * lambda表达式（也称为闭包），允许将函数当成参数传递给方法，或者把代码本身当数据处理
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
//        list.forEach( e -> System.out.println(e));//e的类型是编译器推理得出的
//        list.forEach( (String e) -> System.out.println(e));//也可以显式的制定参数的类型
        list.forEach( e -> {
            System.out.println(e);
            System.out.println(11);
        });
    }

}
