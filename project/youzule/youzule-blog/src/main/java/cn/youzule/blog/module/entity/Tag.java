package cn.youzule.blog.module.entity;

import java.io.Serializable;

/**
 * @title:entity
 * @description:标签表tag
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 17:29
 **/

public class Tag implements Serializable {
    private static final long servialVersionUID = 1L;

    /**
     * id
     **/
    private String id;
    /**
     * code
     **/
    private int code;

    /**
     * name
     **/
    private String name;
    /**
     * createTime
     **/
    private String createTime;
    /**
     * menuCode
     **/
    private String menuCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}
