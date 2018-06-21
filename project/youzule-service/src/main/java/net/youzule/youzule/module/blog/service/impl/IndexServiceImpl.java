package net.youzule.youzule.module.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.youzule.youzule.common.other.PageReq;
import net.youzule.youzule.common.other.PageRes;
import net.youzule.youzule.module.blog.dao.IndexDao;
import net.youzule.youzule.module.blog.dto.req.CommentReq;
import net.youzule.youzule.module.blog.dto.req.KeyWordsDocumentsReq;
import net.youzule.youzule.module.blog.dto.req.SubjectDocumentsReq;
import net.youzule.youzule.module.blog.dto.res.*;
import net.youzule.youzule.module.blog.entity.Menu;
import net.youzule.youzule.module.blog.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 19:54
 **/

@Service
public class IndexServiceImpl implements IndexService {
    private static final Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);
    @Autowired
    private IndexDao indexDao;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public List<MenusRes> getMenus() {
        List<MenusRes> listMenus = (List<MenusRes>) redisTemplate.opsForValue().get("menus");
        logger.info("redis查询结果:{}", JSON.toJSONString(listMenus));
        if (listMenus == null || listMenus.size() <=0){
            listMenus = indexDao.getMenus();
            logger.info("数据库查询结果,并更新到redis:{}",JSON.toJSONString(listMenus));
            redisTemplate.opsForValue().set("menus",listMenus);
        }
        for (MenusRes item:listMenus){
            List<SubMenuRes> subMenuRess = indexDao.getSubMenuByMenuCode(item.getCode());
            item.setSubMenuRes(subMenuRess);
        }
        return listMenus;
    }

    @Override
    public List<SubjectRes> getSubjectBySubMenuCode(int subMenuCode) {

        return indexDao.getSubjectBySubMenuCode(subMenuCode);
    }

    @Override
    public SubMenuRes getSubMenuByCode(int code) {
        return indexDao.getSubMenuByCode(code);
    }

    @Override
    public List<SubjectsRes> getSubjects() {
        List<SubjectsRes> listRes = (List<SubjectsRes>) redisTemplate.opsForValue().get("subjects");
        if(listRes == null){
            listRes = indexDao.getSubjects();
            redisTemplate.opsForValue().set("subjects",listRes);
        }
        return listRes;
    }

    @Override
    public PageRes<DocumentsRes> getSubjectDocuments(SubjectDocumentsReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<DocumentsRes> list = indexDao.getSubjectDocuments(req.getSubjectCode());
        PageInfo<DocumentsRes> pageInfo = new PageInfo<>(list);

        PageRes<DocumentsRes> pageRes = new PageRes<>();
        pageRes.setTotal(pageInfo.getTotal());
        pageRes.setPageCount(pageInfo.getPages());
        //pageRes.setList(pageInfo.getList());
        pageRes.setList(list);
        return pageRes;
    }

    @Override
    public PageRes<DocumentsRes> getKeyWordsDocuments(KeyWordsDocumentsReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<DocumentsRes> list = indexDao.getKeyWordsDocuments(Arrays.asList(req.getKeyWord().split(",")));
        PageInfo<DocumentsRes> pageInfo = new PageInfo<>(list);
        PageRes<DocumentsRes> pageRes = new PageRes<>();
        pageRes.setTotal(pageInfo.getTotal());
        pageRes.setPageCount(pageInfo.getPages());
        pageRes.setList(list);
        return pageRes;
    }

    @Override
    public List<KeyWordsRes> getKeyWords() {
        return indexDao.getKeyWords();
    }

    @Override
    public DocumentRes getDocumentByCode(int code) {
        //可异步执行
        indexDao.updateDocumentViews(code);
        return indexDao.getDocumentByCode(code);
    }

    @Override
    public List<CommentRes> getDocumentComments(int documentCode) {
        return indexDao.getDocumentComments(documentCode);
    }

    @Override
    public int insertComment(CommentReq commentReq) {

        return indexDao.insertComment(commentReq);
    }

    @Override
    public PageRes<DocumentsRes> getDocuments(PageReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<DocumentsRes> list = indexDao.getDocuments();
        PageInfo<DocumentsRes> pageInfo = new PageInfo<>(list);
        PageRes<DocumentsRes> pageRes = new PageRes<>();
        pageRes.setTotal(pageInfo.getTotal());
        pageRes.setPageCount(pageInfo.getPages());
        pageRes.setList(list);
        return pageRes;
    }
}
