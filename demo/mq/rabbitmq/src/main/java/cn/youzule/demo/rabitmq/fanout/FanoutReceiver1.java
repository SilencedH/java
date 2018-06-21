package cn.youzule.demo.rabitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 20:03
 **/

@Component
@RabbitListener(queues = "fanout.a")
public class FanoutReceiver1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout-receiver1: " + message);
    }
}
