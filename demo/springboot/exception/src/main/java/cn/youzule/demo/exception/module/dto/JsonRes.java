package cn.youzule.demo.exception.module.dto;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/27 20:37
 **/

public class JsonRes<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 9999;

    private int code;
    /**
    *message
    **/
    private String msg ;

    private T data;


    public JsonRes() {
    }

    public JsonRes(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
