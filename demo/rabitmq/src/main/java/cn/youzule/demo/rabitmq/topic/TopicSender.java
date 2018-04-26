package cn.youzule.demo.rabitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 17:52
 **/

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(String message){
        System.out.println("topic-sender1: " + message);
        amqpTemplate.convertAndSend("topicExchange","topic.1",message);
    }

    public void send2(String message){
        System.out.println("topic-sender2: " + message);
        amqpTemplate.convertAndSend("topicExchange","topic.message",message);
    }
    public void send3(String message){
        System.out.println("topic-sender3: " + message);
        amqpTemplate.convertAndSend("topicExchange","topic.messages",message);
    }
}
