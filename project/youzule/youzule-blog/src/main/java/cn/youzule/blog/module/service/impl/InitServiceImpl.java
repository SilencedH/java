package cn.youzule.blog.module.service.impl;

import cn.youzule.blog.module.dao.InitDao;
import cn.youzule.blog.module.dto.Page;
import cn.youzule.blog.module.dto.req.*;
import cn.youzule.blog.module.dto.res.GetDocsDtoRes;
import cn.youzule.blog.module.dto.res.GetMenusDto;
import cn.youzule.blog.module.dto.res.GetTagsDto;
import cn.youzule.blog.module.entity.Comment;
import cn.youzule.blog.module.entity.Document;
import cn.youzule.blog.module.entity.Menu;
import cn.youzule.blog.module.service.InitService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @title:service
 * @description:impl
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 18:15
 **/

@Service
public class InitServiceImpl implements InitService {

    private static final Logger logger = LoggerFactory.getLogger(InitServiceImpl.class);

    @Autowired
    private InitDao initDao;

    @Override
    public List<GetMenusDto> getMenus() {
        return initDao.getMenus();
    }

    @Override
    public Menu getMenuByCode(int code) {
        logger.info("调用dao开始，入参:{}", JSON.toJSON(code));
        return initDao.getMenuByCode(code);
    }

    @Override
    public List<GetTagsDto> getTags() {
        return initDao.getTags();
    }

    @Override
    public List<GetTagsDto> getTagsByMenuCode(int menuCode) {
        return initDao.getTagsByMenuCode(menuCode);
    }
    @Override
    public Page<GetDocsDtoRes> getDocs(GetDocsDtoReq req) {
        List<String> keyWordsList = null;
        if(req.getKeyWords() != null){
            keyWordsList = Arrays.asList(req.getKeyWords().split(","));
        }
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<GetDocsDtoRes> list1 = initDao.getDocs(keyWordsList);
        PageInfo<GetDocsDtoRes> pageInfo = new PageInfo<>(list1);
        Page<GetDocsDtoRes> page = new Page<>();
        page.setList(list1);
        page.setPageCount(pageInfo.getPages());
        page.setTotal(pageInfo.getTotal());
        return page;
    }

    @Override
    public Page<Document> getDocsByMenuCode(GetDocsByMenuCodeDtoReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<Document> list = initDao.getDocsByMenuCode(req.getMenuCode());
        PageInfo<Document> pageInfo = new PageInfo<>(list);

        Page<Document> page = new Page<>();
        page.setList(list);
        page.setTotal(pageInfo.getTotal());
        page.setPageCount(pageInfo.getPages());
        return page;
    }

    @Override
    public Page<GetDocsDtoRes> getDocsByTagCode(GetDocsByTagCodeDtoReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<GetDocsDtoRes> list = initDao.getDocsByTagCode(req.getTagCode());
        PageInfo<GetDocsDtoRes> pageInfo = new PageInfo<>(list);
        Page<GetDocsDtoRes> page = new Page<>();
        page.setPageCount(pageInfo.getPages());
        page.setTotal(pageInfo.getTotal());
        page.setList(list);
        return page;
    }

    @Override
    public Page<Comment> getCommentByDocCode(GetCommentDtoReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<Comment> list = initDao.getCommentByDocCode(req.getDocCode());
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        Page<Comment> page = new Page();
        page.setPageCount(pageInfo.getPages());
        page.setTotal(pageInfo.getTotal());
        page.setList(list);
        return page;
    }

    @Override
    public int insertComment(CommentDtoReq req) {
        return initDao.insertComment(req);
    }

    @Override
    public Document getDocByCode(int code) {
        return initDao.getDocByCode(code);
    }

    @Override
    public List<Map<String,String>> getTagsByTagCodes(List<String> list) {
        List<Map<String,String>> tags = new ArrayList<>();
        for(String item:list){
            Map<String,String> map = initDao.getTagByTagCode(item);
            tags.add(map);
        }
        return tags;
    }


}
