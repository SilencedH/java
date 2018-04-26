package cn.youzule.blog.module.dto.res;

import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/13 16:01
 **/

public class GetDocsDtoRes implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *code
    **/
    private int code ;
    /**
    *title
    **/
    private String title ;

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
}
