package net.youzule.youzule.module.blog.controller;

import net.youzule.youzule.common.constant.BaseEnum;
import net.youzule.youzule.common.other.BaseRes;
import net.youzule.youzule.common.other.PageReq;
import net.youzule.youzule.common.other.PageRes;
import net.youzule.youzule.module.blog.dao.IndexDao;
import net.youzule.youzule.module.blog.dto.req.CommentReq;
import net.youzule.youzule.module.blog.dto.req.KeyWordsDocumentsReq;
import net.youzule.youzule.module.blog.dto.req.SubjectDocumentsReq;
import net.youzule.youzule.module.blog.dto.res.*;
import net.youzule.youzule.module.blog.mq.producer.Producer;
import net.youzule.youzule.module.blog.service.IndexService;
import net.youzule.youzule.utils.validator.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title:index
 * @description:博客controller
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 14:47
 **/

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private IndexDao indexDao;




    /*获取所有菜单*/
    @GetMapping("/menus")
    public BaseRes<List<MenusRes>> getMenus() {
        BaseRes<List<MenusRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getMenus());
        return res;
    }

    /*获取所有主题主要信息*/
    @GetMapping("/subjects")
    public BaseRes<List<SubjectsRes>> getSubjects(){
        BaseRes<List<SubjectsRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getSubjects());
        return res;
    }

    /*根据主题编号获取文档列表*/
    @GetMapping("/subject/documents")
    public BaseRes<PageRes<DocumentsRes>> getSubjectDocuments(SubjectDocumentsReq req){
        ValidatorUtil.validate(req);
        BaseRes<PageRes<DocumentsRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getSubjectDocuments(req));
        return res;
    }

    /*根据关键字查询文档列表*/
    @GetMapping("/keywords/documents")
    public BaseRes<PageRes<DocumentsRes>> getKeyWordsDocuments(KeyWordsDocumentsReq req){
        ValidatorUtil.validate(req);
        BaseRes<PageRes<DocumentsRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getKeyWordsDocuments(req));
        return res;
    }

    /*根据文档编号获取文档信息*/
    @GetMapping("/document/{code}")
    public BaseRes<DocumentRes> getDocumentByCode(@PathVariable Integer code){
        BaseRes<DocumentRes> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getDocumentByCode(code));
        return res;
    }

    /*根据文档编号获取评论信息*/
    @GetMapping("/document/comments")
    public BaseRes<List<CommentRes>> getDocumentComments(@RequestParam Integer documentCode){
        BaseRes<List<CommentRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getDocumentComments(documentCode));
        return res;
    }

    /*提交评论*/
    @PostMapping("/comment")
    public BaseRes<Integer> insertComment(@RequestBody CommentReq req){
        ValidatorUtil.validate(req);
        BaseRes<Integer> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.insertComment(req));
        return res;
    }

    /*获取所有文档，按时间排序*/

    @GetMapping("/documents")
    public BaseRes<PageRes<DocumentsRes>> getDocuments(PageReq req){
        ValidatorUtil.validate(req);
        BaseRes<PageRes<DocumentsRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getDocuments(req));
        return res;
    }


    /*===============================测试==============================================*/

    @GetMapping("/test/exception")
    public BaseRes<String> testException(){
        BaseRes<String> res = new BaseRes<>();
        int i = 1 /0;
        return res;
    }


    @GetMapping("/test/mysql")
    public BaseRes<Long> testMysql(){
        BaseRes<Long> res = new BaseRes<>(BaseEnum.SUCCESS);
        Long start = System.currentTimeMillis();
        indexDao.getMenus();
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        res.setData(end -start);
        return res;
    }
    @GetMapping("/test/redis")
    public BaseRes<Long> testRedis(){
        BaseRes<Long> res = new BaseRes<>(BaseEnum.SUCCESS);
        Long start = System.currentTimeMillis();
        redisTemplate.opsForValue().get("menus");
        Long end = System.currentTimeMillis();
        res.setData(end - start);
        return res;
    }

/*==============================废弃======================================================*/
    /*根据子菜单编号subMenuCode获取subject*/
    @GetMapping("/submenu/subjects")
    public BaseRes<List<SubjectRes>> getSubjectsBySubMenuCode(@RequestParam Integer subMenuCode){
        BaseRes<List<SubjectRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getSubjectBySubMenuCode(subMenuCode));
        return res;
    }
    /*根据子菜单编号获取子菜单信息*/
    @GetMapping("/submenu/{code}")
    public BaseRes<SubMenuRes> getSubMenuByCode(@PathVariable Integer code){
        BaseRes<SubMenuRes> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getSubMenuByCode(code));
        return res;
    }
    /*获取所有关键字*/
    @GetMapping("/keywords")
    public BaseRes<List<KeyWordsRes>> getKeyWords(){
        BaseRes<List<KeyWordsRes>> res = new BaseRes<>(BaseEnum.SUCCESS);
        res.setData(indexService.getKeyWords());
        return res;
    }
}
