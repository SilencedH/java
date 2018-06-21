package net.youzule.youzule.module.blog.service.impl;

import com.alibaba.fastjson.JSON;
import net.youzule.youzule.YouzuleServiceApplication;
import net.youzule.youzule.common.other.IpInfo;
import net.youzule.youzule.module.blog.dao.IndexDao;
import net.youzule.youzule.module.blog.dto.req.CommentReq;
import net.youzule.youzule.module.blog.dto.res.MenusRes;
import net.youzule.youzule.module.blog.entity.Menu;
import net.youzule.youzule.module.blog.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YouzuleServiceApplication.class)
public class IndexServiceImplTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private IndexDao indexDao;

    @Autowired
    private IndexService indexService;

    @Test
    public void test7(){
        long mysqlStart = System.currentTimeMillis();

        List<MenusRes> list2 = indexDao.getMenus();
        System.out.println(System.currentTimeMillis()-mysqlStart);

        long redisStart = System.currentTimeMillis();
       List<MenusRes> list = (List<MenusRes>) redisTemplate.opsForValue().get("menus");
        System.out.println(System.currentTimeMillis() - redisStart);


    }




    @Test
    public void test1(){
        IndexService indexService = new IndexServiceImpl();
        CommentReq req = new CommentReq();
        req.setContent("content");
        req.setDocumentCode(2);
        req.setEmail("email");
        req.setName("name");
        int result = indexService.insertComment(req);
        System.out.println(result);
    }

    @Test
    public void test2(){
        redisTemplate.opsForValue().set("name","zdh");
    }

    @Test
    public void test3(){
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void test4(){
        Menu menu = new Menu();
        menu.setCode(1);
        menu.setName("java");
        menu.setCreateUser("zdh");

        redisTemplate.opsForValue().set("menu",menu);
    }

    @Test
    public void test5(){
        System.out.println(JSON.toJSONString(redisTemplate.opsForValue().get("menu")));
    }

    @Test
    public void test6(){
        indexService.getMenus();
    }

    @Test
    public void test8(){

        /*IpInfo ipInfo = new IpInfo();
        ipInfo.setCode(0);

        IpInfo.Data data = new IpInfo.Data();
        data.setArea("aaaaa");
        data.setAreaId("dbbb");
        ipInfo.setData(data);
        System.out.println(JSON.toJSONString(ipInfo));
        redisTemplate.opsForValue().set("ip",ipInfo);

        IpInfo ipInfo1 = (IpInfo) redisTemplate.opsForValue().get("ip");
        System.out.println(JSON.toJSONString(ipInfo1));*/

    }

}