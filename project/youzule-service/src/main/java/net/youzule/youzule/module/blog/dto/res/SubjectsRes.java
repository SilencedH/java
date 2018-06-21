package net.youzule.youzule.module.blog.dto.res;

import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/25 15:10
 **/
public class SubjectsRes implements Serializable{
    private static final long serialVersionUID = 1L;

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
    
    /**
    *二级菜单编号
    **/
    private int subMenuCode;

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

    public int getSubMenuCode() {
        return subMenuCode;
    }

    public void setSubMenuCode(int subMenuCode) {
        this.subMenuCode = subMenuCode;
    }
}
