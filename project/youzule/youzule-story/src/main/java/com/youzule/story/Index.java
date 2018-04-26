package com.youzule.story;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/2 13:51
 **/

@RestController
public class Index {

    @GetMapping("/index")
    public String index(){
        return "story";
    }
}
