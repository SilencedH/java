package cn.youzule.blog.module.dto.res;

import java.io.Serializable;

/**
 * @title:dto
 * @description:getTags
 * @company:
 * @author:zhaodahai
 * @date:2018/4/10 16:17
 **/

public class GetTagsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
    *code
    **/
    private int code ;
    
     /**
     *name
     **/
     private String name ;

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
}
