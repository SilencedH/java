package cn.youzule.blog.module.dto.req;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/11 21:37
 **/

public class CommentDtoReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * name
     **/
    private String name;

    /**
     * ip
     **/
    private String ip;

    /**
     * email
     **/
    private String email;

    /**
     * content
     **/
    @NotBlank(message = "评论内容不能为空")
    private String content;
    /**
    *documentCode
    **/
    @Min(value = 1,message = "文档编号小于1")
    private String docCode ;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }
}
