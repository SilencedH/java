package net.youzule.youzule.module.blog.dao;

import net.youzule.youzule.module.blog.dto.req.CommentReq;
import net.youzule.youzule.module.blog.dto.res.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 14:57
 **/

@Component
@Mapper
public interface IndexDao {
    List<MenusRes> getMenus();
    List<SubMenuRes> getSubMenuByMenuCode(int menuCode);
    List<SubjectRes> getSubjectBySubMenuCode(int subMenuCode);
    SubMenuRes getSubMenuByCode(int code);
    List<SubjectsRes> getSubjects();
    List<DocumentsRes> getSubjectDocuments(int subjectCode);
    List<DocumentsRes> getKeyWordsDocuments(List<String> list);
    List<KeyWordsRes> getKeyWords();
    DocumentRes getDocumentByCode(int code);
    List<CommentRes> getDocumentComments(int documentCode);
    int insertComment(CommentReq commentReq);
    List<DocumentsRes> getDocuments();
    int updateDocumentViews(int code);
}
