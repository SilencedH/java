package net.youzule.youzule.module.blog.dto.res;

import java.io.Serializable;

/**
 * @title:SubjectRes
 * @description:主题名称及文档数量
 * @company:
 * @author:zhaodahai
 * @date:2018/5/24 19:29
 **/

public class SubjectRes implements Serializable{
    private static final Long serialVersionUID = 1L;

    /**
    *code
    **/
    private int code;
    /**
    *name
    **/
    private String name ;
    
    /**
    *文档数量
    **/
    private int documentCount;

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

    public int getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(int documentCount) {
        this.documentCount = documentCount;
    }
}
