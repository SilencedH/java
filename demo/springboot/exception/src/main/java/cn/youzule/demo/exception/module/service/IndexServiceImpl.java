package cn.youzule.demo.exception.module.service;

import org.springframework.stereotype.Service;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/28 13:37
 **/

@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public String index(String name) {
        int a = 3/0;
        return "ok";
    }
}
