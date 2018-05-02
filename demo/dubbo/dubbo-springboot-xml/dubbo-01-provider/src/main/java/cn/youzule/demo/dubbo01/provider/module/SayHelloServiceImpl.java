package cn.youzule.demo.dubbo01.provider.module;

import cn.youzule.demo.dubbo01.api.SayHelloService;
import org.springframework.stereotype.Service;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/24 18:37
 **/

@Service
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
