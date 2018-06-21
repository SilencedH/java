package net.youzule.youzule.module.blog.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @title:评论
 * @description:评论
 * @company:
 * @author:zhaodahai
 * @date:2018/5/28 15:02
 **/

public class CommentRes implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *编号
    **/
    private int code;
    /**
    *评论人
    **/
    private String name ;
    /**
    *评论内容
    **/
    private String content ;
    /**
    *评论时间
    **/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime ;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
