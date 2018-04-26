package cn.youzule.blog.module.controller;

import cn.youzule.blog.module.dto.Page;
import cn.youzule.blog.module.dto.ResJson;
import cn.youzule.blog.module.dto.req.*;
import cn.youzule.blog.module.dto.res.GetDocsDtoRes;
import cn.youzule.blog.module.dto.res.GetMenusDto;
import cn.youzule.blog.module.dto.res.GetTagsDto;
import cn.youzule.blog.module.entity.Comment;
import cn.youzule.blog.module.entity.Document;
import cn.youzule.blog.module.entity.Menu;
import cn.youzule.blog.module.service.InitService;
import com.alibaba.fastjson.JSON;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import javax.websocket.server.PathParam;
import java.util.*;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 16:44
 **/

@RestController
public class InitController {

    @Autowired
    private InitService initService;

    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/init")
    public String init() {
        System.out.println(validator);
        return "init";
    }

    @GetMapping("/redisSet")
    public void setRedis(){
        redisTemplate.opsForValue().set("name","Sean");
    }

    @GetMapping("/redisGet")
    public void getRedis(){
        String name = redisTemplate.opsForValue().get("name").toString();
        System.out.println(name);
    }

    /*根据菜单编号获取菜单*/
    @GetMapping("/menu/{code}")
    public ResJson<Menu> getMenuByCode(@PathVariable(value = "code") int code) {
        ResJson<Menu> res = new ResJson<>();
        Menu menu = initService.getMenuByCode(code);
        res.setCode("0");
        res.setMessage("success");
        res.setData(menu);
        return res;
    }

    /*获取所有菜单*/
    @GetMapping("/menus")
    public ResJson<List<GetMenusDto>> getMenus() {
        ResJson<List<GetMenusDto>> res = new ResJson<>();
        List<GetMenusDto> list = initService.getMenus();
        res.setData(list);
        return res;
    }
    /*获取所有标签*/
    @GetMapping("/tags")
    public ResJson<List<GetTagsDto>> getTags() {
        ResJson<List<GetTagsDto>> res = new ResJson<>();
        List<GetTagsDto> list = initService.getTags();
        res.setData(list);
        return res;
    }
    /*获取所有文档，若有关键字根据关键字获取*/
    @GetMapping("/docs")
    public ResJson<Page<GetDocsDtoRes>> getDocs(GetDocsDtoReq req) {
        ResJson<Page<GetDocsDtoRes>> res = new ResJson<>();
        Set<ConstraintViolation<GetDocsDtoReq>> constraintViolationSet = validator.validate(req);
        if (constraintViolationSet.size() > 0) {
            res.setCode("400");
            res.setMessage(constraintViolationSet.iterator().next().getMessage());
            return res;
        }
        Page<GetDocsDtoRes> page = initService.getDocs(req);
        res.setData(page);
        return res;
    }

    /*根据菜单获取文档list*/
    @GetMapping("/menu/docs")
    public ResJson<Page<Document>> getDocsByMenuCode(GetDocsByMenuCodeDtoReq req){
        ResJson<Page<Document>> res = new ResJson<>();
        Set<ConstraintViolation<GetDocsByMenuCodeDtoReq>> constraintViolationSet = validator.validate(req);
        if (constraintViolationSet.size() > 0) {
            res.setCode("400");
            res.setMessage(constraintViolationSet.iterator().next().getMessage());
            return res;
        }
        Page<Document> page = initService.getDocsByMenuCode(req);
        res.setData(page);
        return res;
    }

    /*根据menuCode获取tags*/
    @GetMapping("/menu/tags")
    public ResJson<List<GetTagsDto>> getTagsByMenuCode(@RequestParam(value = "menuCode") Integer menuCode){
        ResJson<List<GetTagsDto>> res = new ResJson<>();
        System.out.println(menuCode);
        List<GetTagsDto> list = initService.getTagsByMenuCode(menuCode);
        res.setData(list);
        return res;
    }

    /*根据标签获取文档list*/
    @GetMapping("/tag/docs/")
    public ResJson<Page<GetDocsDtoRes>> getDocsByTagCode(GetDocsByTagCodeDtoReq req) {
        ResJson<Page<GetDocsDtoRes>> res = new ResJson<>();
        Set<ConstraintViolation<GetDocsByTagCodeDtoReq>> constraintViolationSet = validator.validate(req);
        if (constraintViolationSet.size() > 0) {
            res.setCode("400");
            res.setMessage(constraintViolationSet.iterator().next().getMessage());
            return res;
        }
        Page<GetDocsDtoRes> page = initService.getDocsByTagCode(req);
        res.setData(page);
        return res;
    }

    /*根据docCode获取doc*/
    @GetMapping("/doc/{code}")
    public ResJson<Map<String,Object>> getDocByCode(@PathVariable(value = "code") Integer code){
        ResJson<Map<String,Object>> res = new ResJson<>();
        Map<String,Object> map = new HashMap<>();
        Document document = initService.getDocByCode(code);
        map.put("document",document);
        /*根据docTags转成tagList*/
        List<String> list = Arrays.asList(document.getTagCode().split(","));
        List<Map<String,String>> tagList = initService.getTagsByTagCodes(list);
        map.put("tags",tagList);
        res.setData(map);
        return res;
    }

    /*根据文档code获取comment*/
    @GetMapping("/doc/comments")
    public ResJson<Page<Comment>> getCommentByDocCode(GetCommentDtoReq req){
        ResJson<Page<Comment>> res = new ResJson<>();
        Set<ConstraintViolation<GetCommentDtoReq>> constraintViolationSet = validator.validate(req);
        if(constraintViolationSet.size()>0){
            res.setCode("400");
            res.setMessage(constraintViolationSet.iterator().next().getMessage());
            return res;
        }
        Page<Comment> page = initService.getCommentByDocCode(req);
        res.setData(page);
        return res;
    }

    /*提交评论*/
    @PostMapping("/comment")
    public ResJson insertComment(HttpServletRequest request, @RequestBody CommentDtoReq req){
        ResJson res = new ResJson();

        Set<ConstraintViolation<CommentDtoReq>> constraintViolationSet = validator.validate(req);
        if(constraintViolationSet.size()>0){
            res.setCode("400");
            res.setMessage(constraintViolationSet.iterator().next().getMessage());
            return res;
        }
        req.setIp(request.getLocalAddr());
        int i = -1;
        try{
            i = initService.insertComment(req);
        }catch (Exception e){
            res.setMessage(e.getMessage());
            res.setCode("500");
            return res;
        }
        return res;
    }



}
