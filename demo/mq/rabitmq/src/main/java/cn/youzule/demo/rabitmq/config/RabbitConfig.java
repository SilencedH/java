package cn.youzule.demo.rabitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 15:21
 **/

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("sean");
    }
}
