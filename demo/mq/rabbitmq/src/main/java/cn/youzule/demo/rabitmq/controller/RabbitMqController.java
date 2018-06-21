package cn.youzule.demo.rabitmq.controller;

import cn.youzule.demo.rabitmq.fanout.FanoutSender;
import cn.youzule.demo.rabitmq.sender.HelloSender;
import cn.youzule.demo.rabitmq.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/26 15:40
 **/

@RestController
public class RabbitMqController {

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;
    @GetMapping("/send/{name}")
    public String send(@PathVariable String name){
        try{
            /*topicSender.send1(name);
            topicSender.send2(name);
            topicSender.send3(name);*/
            fanoutSender.send(name);
        }catch (Exception e){
            return "send fail";
        }
        return "send success";
    }

    public String receive(){

        return "ok";
    }


}
