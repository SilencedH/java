package cn.youzule.blog.module.dto.req;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/11 21:11
 **/

public class GetCommentDtoReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *currentPage
    **/
    @Min(value = 1,message = "当前页数不能小于1")
    private int currentPage;
    /**
    *pageSize
    **/
    @Min(value = 1,message = "页面大小不能小于1")
    private int pageSize;

    /**
    *docCode
    **/
    @Min(value = 1,message = "文档编号不能小于1")
    private int docCode;

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

    public int getDocCode() {
        return docCode;
    }

    public void setDocCode(int docCode) {
        this.docCode = docCode;
    }
}
