package net.youzule.youzule.module.blog.entity;

import net.youzule.youzule.common.other.Ip;

import java.io.Serializable;
import java.util.Date;

/**
 * @title:Request
 * @description:请求
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 17:10
 **/

public class Request extends Ip implements Serializable {
    private static final Long serialVersionUID = 1L;
    private int code;
    private String id;
    private String servletPath;
    private Date requestTime;

    /**
    *响应时间
    **/
    private Date responseTime ;
    
    /**
    *耗时
    **/
    private long elapsedTime ;


    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServletPath() {
        return servletPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}
