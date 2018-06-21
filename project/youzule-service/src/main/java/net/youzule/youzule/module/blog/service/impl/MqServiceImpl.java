package net.youzule.youzule.module.blog.service.impl;

import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.module.blog.dao.MqDao;
import net.youzule.youzule.module.blog.entity.Request;
import net.youzule.youzule.module.blog.service.MqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 16:14
 **/
@Service
public class MqServiceImpl implements MqService {

    private static final Logger logger = LoggerFactory.getLogger(MqServiceImpl.class);

    @Autowired
    private MqDao mqDao;

    @Override
    public int insertMqMessage(MessageEntity<Map<String, String>> messageEntity) {
        return mqDao.insertMqMessage(messageEntity);
    }

    @Override
    public int insertRequest(Request request) {
        return mqDao.insertRequest(request);
    }

    @Override
    public int updateRequest(Map<String, Object> map) {
        return mqDao.updateRequest(map);
    }

    @Override
    public int selectRequestById(String id) {
        return mqDao.selectRequestById(id);
    }
}
