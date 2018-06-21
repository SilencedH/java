package net.youzule.youzule.module.blog.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @title:主题下文档列表
 * @description:主题下文档列表
 * @company:
 * @author:zhaodahai
 * @date:2018/5/25 17:09
 **/

public class DocumentsRes implements Serializable{
    private static final long serialVersionUID = 1L;

    /*        code,title,author,type,create_time,SUBSTRING (content,120),views
     */
    /**
    *编号
    **/
    private int code;
    /**
    *title
    **/
    private String title ;
    /**
    *走着
    **/
    private String author ;
    /**
    *类型
    **/
    private String type ;
    /**
    *创建时间
    **/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime ;
    /**
    *概述
    **/
    private String contentDesc ;
    /**
    *浏览次数
    **/
    private int views;

    /**
    *主题名称
    **/
    private String subjectName ;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
