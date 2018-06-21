package cn.youzule.demo.rabitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 16:35
 **/
@Component
@RabbitListener(queues = "sean")
public class HelloReceiver01 {

    @RabbitHandler
    public void process(String name){
        System.out.println("receiver-2:" + name);
    }
}
