package cn.youzule.blog.module.entity;

import java.io.Serializable;

/**
 * @title:entity
 * @description:文档内容表document
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 17:32
 **/

public class Document implements Serializable {
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
     * title
     **/
    private String title;

    /**
     * author
     **/
    private String author;

    /**
     * type
     **/
    private String type;

    /**
     * createTime
     **/
    private String createTime;
    /**
     * menuCode
     **/
    private String menuCode;
    /**
     * tagCode
     **/
    private String tagCode;
    /**
     * content
     **/
    private String content;

    /**
    *contentHtml
    **/
    private String contentHtml ;


    /**
    *views
    **/
    private String views ;
    
     

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

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
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

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}
