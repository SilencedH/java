package cn.youzule.springcloud.serverfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/4 20:29
 **/

@FeignClient(value = "service-hi",fallback = HelloServiceHystrix.class)
public interface HelloService {

    @GetMapping("/hi")
    String sayHi(@RequestParam(value = "name") String name);
}
