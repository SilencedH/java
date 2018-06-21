package net.youzule.youzule.module.blog.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @title:CommentReq
 * @description:评论
 * @company:
 * @author:zhaodahai
 * @date:2018/5/29 15:33
 **/

public class CommentReq implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
    *文档编号
    **/
    @Min(value = 1,message = "文档编号不能小于0")
    private int documentCode;
    /**
    *用户名称
    **/

    private String name ;
    /**
    *ip
    **/
    private String ip ;
    /**
    *评论内容
    **/
    @NotBlank(message = "文档内容不能为空")
    private String content ;
    /**
    *邮箱
    **/
    private String email ;
    /**
    *时间
    **/
    @NotNull(message = "评论时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime ;

    public int getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(int documentCode) {
        this.documentCode = documentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
