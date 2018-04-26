package cn.youzule.blog.module.dto.res;

import java.io.Serializable;

/**
 * @title:getMenus
 * @description:code and name
 * @company:
 * @author:zhaodahai
 * @date:2018/4/10 16:03
 **/

public class GetMenusDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *code
    **/
    private String code ;

     /**
     *name
     **/
     private String name ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
