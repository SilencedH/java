package cn.youzule.blog.module.entity;

import java.io.Serializable;

/**
 * @title:entity
 * @description:文档评论表comment
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 17:35
 **/

public class Comment implements Serializable {
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
     * documentCode
     **/
    private String documentCode;
    /**
     * name
     **/
    private String name;
    /**
     * email
     **/
    private String email;

    /**
     * ip
     **/
    private String ip;

    /**
     * content
     **/
    private String content;

    /**
     * createTiem
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

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
