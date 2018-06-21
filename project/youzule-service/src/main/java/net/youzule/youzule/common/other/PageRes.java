package net.youzule.youzule.common.other;

import java.io.Serializable;
import java.util.List;

/**
 * @title:pageRes
 * @description:分页基本出参
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 18:28
 **/


public class PageRes<T> implements Serializable{
    private static final Long serialVersionUID = 1L;
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
