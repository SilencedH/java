package cn.youzule.blog.module.dao;

import cn.youzule.blog.module.dto.Page;
import cn.youzule.blog.module.dto.req.CommentDtoReq;
import cn.youzule.blog.module.dto.res.GetDocsDtoRes;
import cn.youzule.blog.module.dto.res.GetMenusDto;
import cn.youzule.blog.module.dto.res.GetTagsDto;
import cn.youzule.blog.module.entity.Comment;
import cn.youzule.blog.module.entity.Document;
import cn.youzule.blog.module.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @title:dao
 * @description:初始化
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 18:07
 **/
@Component
@Mapper
public interface InitDao {
    List<GetMenusDto> getMenus();
    Menu getMenuByCode(int code);
    List<GetTagsDto> getTags();
    List<GetDocsDtoRes> getDocs(List list);
    List<Document> getDocsByMenuCode(int menuCode);
    List<GetDocsDtoRes> getDocsByTagCode(int tagCode);
    List<Comment> getCommentByDocCode(int docCode);
    int insertComment(CommentDtoReq req);
    List<GetTagsDto> getTagsByMenuCode(int menuCode);
    Document getDocByCode(int code);

    Map<String,String> getTagByTagCode(String code);
}