package cn.youzule.demo.dubbo.consumer;

import cn.youzule.demo.dubbo.api.SayHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/24 17:01
 **/

public class ConsumerApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/consumer.xml");
        context.start();
        System.out.println("consumer启动:");
        SayHelloService sayHelloService = context.getBean(SayHelloService.class);
        String result = sayHelloService.sayHello("sean");
        System.out.println(result);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
