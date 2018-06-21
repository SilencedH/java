package net.youzule.youzule.module.blog.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @title:
 * @description:根据文档code获取信息
 * @company:
 * @author:zhaodahai
 * @date:2018/5/28 14:20
 **/

public class DocumentRes implements Serializable{
    private static final Long serialVersionUID = 1L;

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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime ;
    /**
     *文档内容
     **/
    private String contentHtml ;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
