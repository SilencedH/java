package net.youzule.youzule.module.blog.service;

import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.module.blog.entity.Request;

import java.util.Map;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 16:14
 **/

public interface MqService {
    int insertMqMessage(MessageEntity<Map<String,String>> messageEntity);
    int insertRequest(Request request);
    int updateRequest(Map<String,Object> map);
    int selectRequestById(String id);

}
