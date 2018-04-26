package cn.youzule.blog.module.dto.req;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/11 20:51
 **/

public class GetDocsByMenuCodeDtoReq implements Serializable {

    private static final long serivalVersionUID = 1L;

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
    *menuCode
    **/
    @Min(value = 1,message = "菜单编号必须大于1")
    private int menuCode;

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

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
}
