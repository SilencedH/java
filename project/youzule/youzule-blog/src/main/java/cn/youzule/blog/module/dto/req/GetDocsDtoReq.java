package cn.youzule.blog.module.dto.req;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @title:dto
 * @description:getDocsList
 * @company:
 * @author:zhaodahai
 * @date:2018/4/10 18:26
 **/

public class GetDocsDtoReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *currentPage
    **/
    @Min(value = 1,message = "当前页数必须大于1")
    private int currentPage;
    /**
    *pageSize
    **/
    @Min(value = 1,message = "页面大小必须大于1")
    private int pageSize;

    /**
    *keyWords
    **/
    private String keyWords;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
