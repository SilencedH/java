package net.youzule.youzule.common.other;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 11:32
 **/

public class MessageEntity<T> implements Serializable{
    private static final Long serialVersionUID = 1L;
    /**
    *id
    **/
    private String id ;

    /**
    *当前时间戳
    **/
    private Date time ;

    /**
    *数据
    **/
    private T data  ;

    private String queueName;


    public MessageEntity() {
    }
    public MessageEntity(T data){
        this.id = UUID.randomUUID().toString();
        this.time = new Date();
        this.data = data;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
