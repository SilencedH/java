package net.youzule.youzule.module.blog.dto.res;

import java.io.Serializable;
import java.util.List;

/**
 * @title:菜单dto
 * @description:获取所有菜单
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 15:44
 **/

public class MenusRes implements Serializable{
    private static final Long serialVersionUID = 1L;
    
    /**
    *code
    **/
    private int code;
    /**
    *name
    **/
    private String name ;
    

    private List<SubMenuRes> subMenuRes;

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

    public List<SubMenuRes> getSubMenuRes() {
        return subMenuRes;
    }

    public void setSubMenuRes(List<SubMenuRes> subMenuRes) {
        this.subMenuRes = subMenuRes;
    }
}
