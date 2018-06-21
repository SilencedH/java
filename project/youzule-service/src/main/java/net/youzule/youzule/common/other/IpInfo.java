package net.youzule.youzule.common.other;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @title:IpInfo
 * @description:ip信息
 * @company:
 * @author:zhaodahai
 * @date:2018/5/18 17:36
 **/

public class IpInfo implements Serializable{
    private static final Long serialVersionUID = 1L;

    /**
    *code,0成功，1失败
    **/
    private int code ;

    private Ip ip;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Ip getIp() {
        return ip;
    }
    @JSONField(name = "data")
    public void setIp(Ip ip) {
        this.ip = ip;
    }




}
