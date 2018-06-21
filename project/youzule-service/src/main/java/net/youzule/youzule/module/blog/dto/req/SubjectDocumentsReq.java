package net.youzule.youzule.module.blog.dto.req;

import net.youzule.youzule.common.other.PageReq;

import javax.validation.constraints.Min;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/25 17:22
 **/

public class SubjectDocumentsReq extends PageReq{
    /**
    *主题编号
    **/
    @Min(value = 1,message = "主题编号不能小于1")
    private int subjectCode;

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }
}
