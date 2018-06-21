package net.youzule.youzule.module.blog.dto.res;

import java.io.Serializable;

/**
 * @title:SubMenu
 * @description:子菜单
 * @company:
 * @author:zhaodahai
 * @date:2018/5/24 18:19
 **/

public class SubMenuRes implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *code
    **/
    private int code ;

    /**
    *名称
    **/
    private String name ;

    /**
    *menu_code
    **/
    private int menuCode;

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

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
}
