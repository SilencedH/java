package net.youzule.youzule.module.blog.dao;

import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.module.blog.entity.Request;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 16:04
 **/

@Component
@Mapper
public interface MqDao {
    int insertMqMessage(MessageEntity<Map<String,String>> messageEntity);
    int insertRequest(Request request);
    int updateRequest(Map<String,Object> map);
    int selectRequestById(String id);
}
