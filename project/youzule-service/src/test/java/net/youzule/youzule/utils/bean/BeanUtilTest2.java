package net.youzule.youzule.utils.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 17:41
 **/

public class BeanUtilTest2 {

    @Test
    public void test1(){
        Father father = new Father();
        father.setName("sean");

        String jsonObject = JSON.toJSONString(father);

        Son son = JSON.parseObject(jsonObject,Son.class);


        System.out.println(JSON.toJSONString(son));

    }
}
