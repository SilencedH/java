package cn.youzule.springcloud.serverfeign.controller;

import cn.youzule.springcloud.serverfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/4 20:32
 **/
@Component
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public String hello(@RequestParam(value = "name") String name){
        System.out.println("feign server");
        return helloService.sayHi(name);
    }
}
