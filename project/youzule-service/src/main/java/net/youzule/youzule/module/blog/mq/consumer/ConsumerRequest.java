package net.youzule.youzule.module.blog.mq.consumer;

import com.alibaba.fastjson.JSON;
import net.youzule.youzule.common.constant.OtherConstant;
import net.youzule.youzule.common.constant.QueueConstant;
import net.youzule.youzule.common.other.IpInfo;
import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.module.blog.entity.Request;
import net.youzule.youzule.module.blog.service.MqService;
import net.youzule.youzule.utils.bean.BeanUtil;
import net.youzule.youzule.utils.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @title:mq消费者
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/2 18:32
 **/
@Service
public class ConsumerRequest {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerRequest.class);

    @Autowired
    private MqService mqService;

    /*消费request*/
    @RabbitListener(queues = QueueConstant.REQUEST)
    @RabbitHandler
    public void consumeRequest1(Message message) {
        doConsume(message,1);
    }

    public void doConsume(Message message,int code){
        byte[] bytes = message.getBody();
        //先将消息转为messageEntity对象
        MessageEntity<Map<String,String>> messageEntity = (MessageEntity<Map<String,String>>) BeanUtil.byteArrayToObject(bytes);
        messageEntity.setQueueName(QueueConstant.REQUEST);

        logger.info(code + "号消费者开始消费消息mq-request:{}",JSON.toJSONString(messageEntity));
        try{
            //消息入库
            logger.info("mq-request消息入库:{}",JSON.toJSONString(messageEntity));
            mqService.insertMqMessage(messageEntity);
            /*
            处理请求信息
            */
            //获取信息
            Map<String,String> map = messageEntity.getData();
            String ip = map.get("ip");
            String id = map.get("id");
            String servletPath = String.valueOf(map.get("servletPath"));
            long start = Long.valueOf(map.get("start"));
            long end = Long.valueOf(map.get("end"));
            //查询Ip信息
            logger.info("调用淘宝IP接口,线程睡眠250毫秒,入参:{}",ip);
            Thread.sleep(250);
            String result = HttpUtil.get(OtherConstant.IP_TAOBAO + ip);
            //定义请求实体
            Request request = new Request();
            if(result != "999"){
                logger.info("调用淘宝IP接口出参:{}",result);
                IpInfo ipInfo = JSON.parseObject(result,IpInfo.class);
                //将ip转为json
                if(ipInfo.getCode() == 0){
                    String ipString = JSON.toJSONString(ipInfo.getIp());
                    request = JSON.parseObject(ipString, Request.class);
                }else{
                    logger.info("淘宝ip查询返回code=1,未查到结果");
                }
            }
            request.setId(id);
            request.setRequestTime(new Date(start));
            request.setResponseTime(new Date(end));
            request.setElapsedTime(end - start);
            request.setServletPath(servletPath);
            logger.info("请求信息插入到数据库:{}",JSON.toJSONString(request));
            mqService.insertRequest(request);
        }catch (Exception e){
            logger.info("消费消息mq-request异常:{}" , e);
        }
    }


}
