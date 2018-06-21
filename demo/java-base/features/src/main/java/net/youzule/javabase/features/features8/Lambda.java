package net.youzule.javabase.features.features8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @title:8新特性
 * @description:lambda表达式
 * @company:
 * @author:zhaodahai
 * @date:2018/6/4 10:54
 **/

public class Lambda {


    /*初步使用*/
    @Test
    public void test1(){
        /*8之前使用方式*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before 8");
            }
        }).start();

        /*8之后*/
        new Thread(()->{
            System.out.println("after 8 ");
        }).start();
    }

    /*List遍历*/
    @Test
    public void test2(){
        /*8之前*/
        List<String> features = Arrays.asList("lambda","default method","stream api","date and time api");
        for (String item:features){
            System.out.println(item);
        }
        System.out.println("=========after8==============");
        /*8之后*/
        features.forEach(n ->
            System.out.println(n)
        );
        System.out.println("=========方法引用==========");
        features.forEach(System.out::println);
    }
    /*方法引用*/
    @Test
    public void test3(){

    }

    /*使用lambda表达式和函数式接口Predicate*/
    @Test
    public void tet4(){
        List<String> list = Arrays.asList("Java","C","JavaScripg","Scala","C++","Python","PHP");
        filter(list,(str)->String.valueOf(str).startsWith("j"));

    }

    /*过滤函数*/
    public void filter(List<String> list, Predicate predicate){
        for (String item:list){
            if(predicate.test(item)){
                System.out.println(item);
            }
        }
    }

}
