package cn.youzule.blog.module.entity;

import java.io.Serializable;

/**
 * @title:entity
 * @description:菜单表menu
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 17:24
 **/

public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
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
}
