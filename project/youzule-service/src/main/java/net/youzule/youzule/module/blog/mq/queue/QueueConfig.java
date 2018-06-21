package net.youzule.youzule.module.blog.mq.queue;

import net.youzule.youzule.common.constant.QueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title:mq队列
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/2 18:33
 **/

@Configuration
public class QueueConfig {

    /*测试队列*/
   /* @Bean
    public Queue queueTest(){
        return new Queue("test");
    }*/

    @Bean
    public Queue queueRequest(){
        return new Queue(QueueConstant.REQUEST);
    }
}
