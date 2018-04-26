package cn.youzule.blog.module.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @title:dto
 * @description:page
 * @company:
 * @author:zhaodahai
 * @date:2018/4/10 18:13
 **/

public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    *totalCount
    **/
    private long total;
    /**
    *totalPages
    **/
    private int pageCount;

    /**
    *list数据
    **/
    private List<T> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
