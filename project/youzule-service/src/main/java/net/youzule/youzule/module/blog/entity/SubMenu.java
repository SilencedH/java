package net.youzule.youzule.module.blog.entity;

import java.io.Serializable;

/**
 * @title:SubMenu
 * @description:二级菜单
 * @company:
 * @author:zhaodahai
 * @date:2018/5/25 14:08
 **/


public class SubMenu implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
    *code
    **/
    private int code;
    /**
    *名称
    **/
    private String name ;
    /**
    *上级菜单code
    **/
    private int menuCode;
    
    private String createTime;
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

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
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
