package cn.youzule.demo.exception.module.controller;

import cn.youzule.demo.exception.module.common.BusinessException;
import cn.youzule.demo.exception.module.dto.JsonRes;
import cn.youzule.demo.exception.module.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/27 20:53
 **/

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/index/{name}")
    public String index(@PathVariable String name) throws BusinessException {
        return "ok";
    }

    @PostMapping("/post")
    public String post(){
        return "post";
    }

    @PostMapping("/param")
    public JsonRes<String> param(@RequestParam(value = "name") String name,@RequestParam(value = "age") Integer age){
        JsonRes<String> res = new JsonRes<>(0,"SUCCESS");
        System.out.println(name);
        System.out.println(age);
        res.setData("ok");
        return res;
    }

    @GetMapping("/byZero")
    public String byZero(){
        indexService.index("k");
        return "ok";
    }
}
