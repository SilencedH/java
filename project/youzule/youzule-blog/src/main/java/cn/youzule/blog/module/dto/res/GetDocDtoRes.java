package cn.youzule.blog.module.dto.res;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/16 11:44
 **/

public class GetDocDtoRes implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *document
    **/
    private String document ;

     /**
     *tags
     **/
     private List<Map<String,String>> tags ;



}
