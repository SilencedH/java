package cn.youzule.demo.rabitmq.topic;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 17:44
 **/

@Configuration
public class TopicConfig {

    public static String message = "topic.message";
    public static String messages = "topic.messages";

    @Bean
    public Queue message(){
        return new Queue(TopicConfig.message);
    }

    @Bean
    public Queue messages(){
        return new Queue(TopicConfig.messages);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingMessage(Queue message,TopicExchange exchange){
        return BindingBuilder.bind(message).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingMessages(Queue messages,TopicExchange exchange){
        return BindingBuilder.bind(messages).to(exchange).with("topic.#");
    }
}
