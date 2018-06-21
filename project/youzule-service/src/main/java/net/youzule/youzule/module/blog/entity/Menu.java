package net.youzule.youzule.module.blog.entity;

import java.io.Serializable;

/**
 * @title:menu
 * @description:菜单
 * @company:
 * @author:zhaodahai
 * @date:2018/5/15 15:21
 **/
public class Menu implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
    *code
    **/
    private int code;
    /**
    *名称
    **/
    private String name ;

    /**
    *创建时间
    **/
    private String createTime ;
    /**
    *创建人
    **/
    private String createUser ;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
