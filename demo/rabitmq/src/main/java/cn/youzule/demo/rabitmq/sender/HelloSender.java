package cn.youzule.demo.rabitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 15:28
 **/

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String name){
        String context = "hello "+ name;
        System.out.println("Sender: " + context);
        amqpTemplate.convertAndSend("sean",context);
    }
}
