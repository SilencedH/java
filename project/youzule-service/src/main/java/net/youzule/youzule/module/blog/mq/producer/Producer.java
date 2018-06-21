package net.youzule.youzule.module.blog.mq.producer;

import com.alibaba.fastjson.JSON;
import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.utils.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title:mq生产者
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/2 18:32
 **/

@Service
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    //发送消息方法，队列发送
    public void sendMessage(String queue, MessageEntity messageEntity){
        byte[] bytes = BeanUtil.objectToByteArray(messageEntity);
        Message message = MessageBuilder.withBody(bytes).build();
        logger.info("开始发送mq:");
        try{
            amqpTemplate.convertAndSend(queue,message);
        }catch (Exception e){
            logger.info("发送异常:{}" , e);
        }
    }

}
