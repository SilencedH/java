package net.youzule.youzule.module.blog.dto.req;

import net.youzule.youzule.common.other.PageReq;

import javax.validation.constraints.NotEmpty;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/27 12:41
 **/


public class KeyWordsDocumentsReq extends PageReq {
    @NotEmpty
    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
