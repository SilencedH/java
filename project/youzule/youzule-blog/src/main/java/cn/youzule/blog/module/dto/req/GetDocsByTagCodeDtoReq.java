package cn.youzule.blog.module.dto.req;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/11 18:45
 **/

public class GetDocsByTagCodeDtoReq implements Serializable{
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

    @Min(value = 1,message = "标签必须大于0")
    private int tagCode;

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

    public int getTagCode() {
        return tagCode;
    }

    public void setTagCode(int tagCode) {
        this.tagCode = tagCode;
    }
}
