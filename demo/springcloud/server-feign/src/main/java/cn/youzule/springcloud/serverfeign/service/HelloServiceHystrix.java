package cn.youzule.springcloud.serverfeign.service;

import org.springframework.stereotype.Component;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/5 18:15
 **/

@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String sayHi(String name) {
        return "sorry, " + name + " error.";
    }
}
