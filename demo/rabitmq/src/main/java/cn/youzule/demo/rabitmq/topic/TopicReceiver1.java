package cn.youzule.demo.rabitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 17:59
 **/

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("topic-receiver1: " + message);
    }
}
