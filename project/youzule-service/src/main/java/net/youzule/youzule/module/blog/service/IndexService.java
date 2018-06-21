package net.youzule.youzule.module.blog.service;

import net.youzule.youzule.common.other.PageReq;
import net.youzule.youzule.common.other.PageRes;
import net.youzule.youzule.module.blog.dto.req.CommentReq;
import net.youzule.youzule.module.blog.dto.req.KeyWordsDocumentsReq;
import net.youzule.youzule.module.blog.dto.req.SubjectDocumentsReq;
import net.youzule.youzule.module.blog.dto.res.*;

import java.util.List;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 19:53
 **/

public interface IndexService {
    List<MenusRes> getMenus();
    List<SubjectRes> getSubjectBySubMenuCode(int subMenuCode);
    SubMenuRes getSubMenuByCode(int code);
    List<SubjectsRes> getSubjects();
    PageRes<DocumentsRes> getSubjectDocuments(SubjectDocumentsReq req);
    PageRes<DocumentsRes> getKeyWordsDocuments(KeyWordsDocumentsReq req);
    List<KeyWordsRes> getKeyWords();
    DocumentRes getDocumentByCode(int code);
    List<CommentRes> getDocumentComments(int documentCode);
    int insertComment(CommentReq commentReq);
    PageRes<DocumentsRes> getDocuments(PageReq req);

}
