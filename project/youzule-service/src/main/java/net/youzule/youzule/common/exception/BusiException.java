package net.youzule.youzule.common.exception;

import java.io.Serializable;

/**
 * @title:BusiException
 * @description:统一异常处理
 * @company:
 * @author:zhaodahai
 * @date:2018/5/14 19:32
 **/

public class BusiException extends RuntimeException implements Serializable{
    private static final Long serialVersionUID = 1L;

    private String msg;
    private int code;

    /*构造方法*/
    public BusiException(final String msg){
        super(msg);
        this.msg = msg;
    }

    public BusiException(final String msg, final Throwable e){
        super(msg,e);
        this.msg = msg;
    }

    public BusiException(final int code,final String msg){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusiException(final int code,final String msg,Throwable e){
        super(msg,e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
