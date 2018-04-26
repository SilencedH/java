package cn.youzule.demo.rabitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 20:01
 **/

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message){
        amqpTemplate.convertAndSend("fanoutExchange","",message);
    }
}
