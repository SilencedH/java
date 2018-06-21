package net.youzule.youzule.module.blog.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @title:评论
 * @description:平路
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 15:28
 **/

public class Comment implements Serializable{
    private static final Long serialVersionUID = 1L;


    /**
    *code
    **/
    private int code;
    /**
    *文档编号
    **/
    private int documentCode;
    /**
    *姓名
    **/
    private String name ;
    /**
    *邮箱
    **/
    private String email ;
    /**
    *内容
    **/
    @NotBlank
    private String content ;
    /**
    *ip
    **/
    private String ip ;
    /**
    *时间
    **/
    private String createTime ;
    
    /**
    *省
    **/
    private String province ;
    /**
    *市
    **/
    private String city ;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(int documentCode) {
        this.documentCode = documentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
