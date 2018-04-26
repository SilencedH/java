package cn.youzule.demo.rabitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 19:45
 **/

@Configuration
public class FanoutConfig {

    @Bean
    public Queue AMessage(){
        return new Queue("fanout.a");
    }

    @Bean
    public Queue BMessage(){
        return new Queue("fanout.b");
    }

    @Bean
    public Queue CMessage(){
        return new Queue("fanout.c");
    }

    /*配置交换机*/
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /*交换机绑定队列*/
    @Bean
    public Binding bindingAExchange(Queue AMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    public Binding bindingBExchange(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    public Binding bindingCExchange(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
