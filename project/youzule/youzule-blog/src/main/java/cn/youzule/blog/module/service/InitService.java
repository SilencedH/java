package cn.youzule.blog.module.service;

import cn.youzule.blog.module.dto.Page;
import cn.youzule.blog.module.dto.req.*;
import cn.youzule.blog.module.dto.res.GetDocsDtoRes;
import cn.youzule.blog.module.dto.res.GetMenusDto;
import cn.youzule.blog.module.dto.res.GetTagsDto;
import cn.youzule.blog.module.entity.Comment;
import cn.youzule.blog.module.entity.Document;
import cn.youzule.blog.module.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @title:service
 * @description:init
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 18:14
 **/

public interface InitService {
    List<GetMenusDto> getMenus();
    Menu getMenuByCode(int code);
    List<GetTagsDto> getTags();
    List<GetTagsDto> getTagsByMenuCode(int menuCode);
    Page<GetDocsDtoRes> getDocs(GetDocsDtoReq req);
    Page<Document> getDocsByMenuCode(GetDocsByMenuCodeDtoReq req);
    Page<GetDocsDtoRes> getDocsByTagCode(GetDocsByTagCodeDtoReq req);
    Page<Comment> getCommentByDocCode(GetCommentDtoReq req);
    int insertComment(CommentDtoReq req);
    Document getDocByCode(int code);
    List<Map<String,String>> getTagsByTagCodes(List<String> list);
}
