package cn.youzule.demo.dubbo01.consumer.module;

import cn.youzule.demo.dubbo01.api.SayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/24 18:43
 **/

@RestController
public class SayHelloServiceController {

    @Autowired
    private SayHelloService sayHelloService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return sayHelloService.sayHello("Sean");
    }
}
