package cn.youzule.demo.rabitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 15:31
 **/

@Component
@RabbitListener(queues = "sean")
public class HelloReceiver {


    @RabbitHandler
    public void process(String hello){
        System.out.println("receiver: " + hello);

    }
}
