package cn.youzule.demo.dubbo.provider.module.impl;

import cn.youzule.demo.dubbo.api.SayHelloService;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/24 16:51
 **/

public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
