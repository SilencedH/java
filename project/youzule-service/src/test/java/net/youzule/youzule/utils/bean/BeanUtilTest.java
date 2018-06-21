package net.youzule.youzule.utils.bean;

import com.alibaba.fastjson.JSON;
import net.youzule.youzule.module.blog.dao.IndexDao;
import net.youzule.youzule.module.blog.dto.res.DocumentsRes;
import net.youzule.youzule.module.blog.entity.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class BeanUtilTest {

    @Autowired
    IndexDao indexDao;

    @Test
    public void test1() {
        Menu menu = new Menu();
        menu.setCode(1);
        menu.setName("java");
        System.out.println(BeanUtil.object2Map(menu));

    }

    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("cc", "aa");
        map.put("aa", "bb");
        map.put("bb", "cc");
        /*排序之前*/
        System.out.println("before:");
        for (Map.Entry<String, Object> item : map.entrySet()) {
            System.out.println(item.getKey());
        }
        map = BeanUtil.sortMap(map);
        System.out.println("after:");
        for (Map.Entry<String, Object> item : map.entrySet()) {
            System.out.println(item.getKey());
        }
    }

    @Test
    public void test3() {
        Map<String,Object> map = new HashMap<>();
        map.put("aa+B","a_a");
        map.put("zz+B","z_z");
        map.put("cc+B","c_c");

        System.out.println("排序之前");
        for (Map.Entry<String,Object> item:map.entrySet()){
            System.out.println(item.getKey());
        }
        map = BeanUtil.sortMap(map);
        System.out.println("排序之后");
        for (Map.Entry<String,Object> item:map.entrySet()){
            System.out.println(item.getKey());
        }
    }

    @Test
    public void test4() {
        Map<String,Object> map = new HashMap<>();
        map.put("aa","a_a");
        map.put("zz","z_z");
        map.put("cc","c_c");

        List<Map.Entry<String,Object>> list = new ArrayList<>(map.entrySet());
        for (int i = 0; i<list.size();i++){
            System.out.println(list.get(i).getKey());
        }

    }

    @Test
    public void test5(){
        Map<String,Object> map = new HashMap<>();
        map.put("a_a","a_a");
        map.put("z_z","z_z");
        map.put("c_c",null);
        map = BeanUtil.sortMap2(map);
        for (Map.Entry<String,Object> item:map.entrySet()){
            System.out.println(item.getKey());
        }
    }

    @Test
    public void test6(){
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < 200; i ++){
            map.put(String.valueOf(i),i);
        }

        for (Map.Entry<String,Object> item:map.entrySet()){
            System.out.println(item.getKey());
        }
        map = null;
    }

    @Test
    public void test7(){
        String str = "aaa";
        String json = JSON.toJSONString(str);
        System.out.println(json);
    }

    @Test
    public void test8(){
        String [] strs = {"aa","bb","cc"};
    }

    @Test
    public void test9(){
        Menu menu = new Menu();
        menu.setCreateUser("sean");
        menu.setName("zdh");
        menu.setCode(1);
        menu.setCreateTime("2018-06-12");

        byte[] bytes = BeanUtil.objectToByteArray(menu);
        Object o = BeanUtil.byteArrayToObject(bytes);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void test10(){
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test11(){
        Map<String,Object> map = new HashMap<>();
        map.put("ip","ip");
        System.out.println(map.toString());
    }


}