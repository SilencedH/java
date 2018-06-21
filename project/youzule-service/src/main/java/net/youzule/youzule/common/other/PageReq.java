package net.youzule.youzule.common.other;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @title:分页请求参数
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 18:03
 **/


public class PageReq implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
    *当前页数
    **/
    @Min(message = "当前页数必须大于0",value = 1)
    private int currentPage;
    /**
    *每页条数
    **/
    @Min(value = 1,message = "每页条数必须大于0")
    private int pageSize;

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
}
