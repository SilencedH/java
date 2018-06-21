package net.youzule.youzule.module.blog.entity;

import java.io.Serializable;

/**
 * @title:文档
 * @description:文档
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 15:23
 **/

public class Document implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
    *编号
    **/
    private int code;
    /**
    *标题
    **/
    private String title ;
    
    /**
    *作者
    **/
    private String author ;
    /**
    *类型
    **/
    private String type ;
    /**
    *文档创建时间
    **/
    private String createTime ;
    /**
    *创建人
    **/
    private String createUser ;
    /**
    *菜单编号
    **/
    private int menuCode;
    /**
    *标签
    **/
    private String tagCode ;
    /**
    *内容
    **/
    private String content ;
    /**
    *html内容
    **/
    private String contentHtml ;
    /**
    *浏览次数
    **/
    private int views;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
