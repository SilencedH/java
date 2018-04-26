package cn.youzule.demo.rabitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 20:05
 **/

@Component
@RabbitListener(queues = "fanout.b")
public class FanoutReceiver2 {

    @RabbitHandler
    public void solve(String message){
        System.out.println("receiver2: " + message);
    }
}
