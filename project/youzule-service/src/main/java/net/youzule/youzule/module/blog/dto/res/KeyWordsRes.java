package net.youzule.youzule.module.blog.dto.res;

import java.io.Serializable;

/**
 * @title:KeyWords
 * @description:所有关键字
 * @company:
 * @author:zhaodahai
 * @date:2018/5/28 10:47
 **/

public class KeyWordsRes implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
    *编号
    **/
    private int code;
    /**
    *名称
    **/
    private String name ;

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
}
