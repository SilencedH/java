package net.youzule.youzule.common.other;

import net.youzule.youzule.common.constant.BaseEnum;

import java.io.Serializable;

/**
 * @title:baseRes
 * @description:出参json
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 19:47
 **/


public class BaseRes<T> implements Serializable{
    private static final Long serialVersionUID = 1L;
    /**
    *code
    **/
    private int code;
    /**
    *msg
    **/
    private String msg ;
    /*
    * 数据
    * */
    private T data;

    public BaseRes() {
    }

    public BaseRes(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseRes(BaseEnum baseEnum) {
        this.code = baseEnum.getCode();
        this.msg = baseEnum.getDesc();
    }

    public BaseRes(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
