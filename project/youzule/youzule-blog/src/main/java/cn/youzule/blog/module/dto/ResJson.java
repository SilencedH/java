package cn.youzule.blog.module.dto;

import java.io.Serializable;

/**
 * @title:dto
 * @description:通用返回json
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 17:19
 **/

public class ResJson<T> implements Serializable{
    private static final long servialVersionUID = 1L;

    /**
    *code
    **/
    private String code ="0";
    /**
    *message
    **/
    private String message = "SUCCESS";

    /**
    *data
    **/
    private T data ;

    public ResJson() {
    }

    public ResJson(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResJson(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
