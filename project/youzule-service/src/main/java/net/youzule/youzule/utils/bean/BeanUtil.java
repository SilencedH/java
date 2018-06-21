package net.youzule.youzule.utils.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.omg.CORBA.OBJ_ADAPTER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @title:bean
 * @description:bean处理类
 * @company:
 * @author:zhaodahai
 * @date:2018/5/15 15:17
 **/

public class BeanUtil {


    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * @Description: json转map
     * @Param: String
     * @return: map
     * @Author: zhaodahai
     * @Date: 2018/5/15
     */
    public static Map<String, Object> json2Map(String json) {
        return JSONObject.parseObject(json, new TypeReference<HashMap<String, Object>>() {
        });
    }


    /**
     * @Description: obj转map 注意这个obj不能是fastjson转的obj
     * @Param: obj
     * @return: map
     * @Author: zhaodahai
     * @Date: 2018/5/15
     */
    public static Map<String, Object> object2Map(Object o) {
        try {
            Map<String, Object> map = new HashMap<>();
            BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            /*遍历数组，注意多了个属性class，要过滤掉*/
            for (PropertyDescriptor item : propertyDescriptors) {
                if (!"class".equals(item.getName())) {
                    Method getter = item.getReadMethod();
                    //getter.setAccessible(true);
                    Object value = getter.invoke(o);
                    map.put(item.getName(), value);
                }
            }
            return map;
        } catch (Exception e) {
            logger.error("对象转Map异常", e);
            return null;
        }
    }

    /**
    * @Description: map按照key排序=====================已废，不用
    * @Param: map
    * @return: map
    * @Author: zhaodahai
    * @Date: 2018/5/15
    */
    public static Map<String,Object> sortMap2(Map<String, Object> map) {
        //使用list排序实现
        List<String> list = new ArrayList<>();
        //遍历map将Key放入list
        for (Map.Entry<String,Object> item:map.entrySet()){
            list.add(item.getKey());
        }
        //定义比较器
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        //list排序

        Collections.sort(list,comparator);
        Map<String,Object> result = new HashMap<>();
        //遍历list,将map按照舒徐放入result
        for (String item:list){
            System.out.println("list-value:" + item);
            result.put(item.toString(),map.get(item));
        }
        for (Map.Entry<String,Object> item:result.entrySet()){
            System.out.println("result-key:" + item.getKey());
        }
        return result;
       /* *//*定义比较器*//*
        Comparator<Map.Entry<String,Object>> comparator = new Comparator<Map.Entry<String, Object>>() {
            @Override
            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        };

        //list排序
        Collections.sort(list, comparator);
        map = new HashMap<>();
        for (Map.Entry<String,Object> item:list){
            map.put(item.getKey(),item.getValue());
        }
        return map;*/
    }

    /**
    * @Description: hashmap按照key排序，使用treeMap实现
    * @Param: map
    * @return:
    * @Author: zhaodahai
    * @Date: 2018/5/16
    */
    public static Map<String,Object> sortMap(Map<String, Object> map) {
        TreeMap<String,Object> treeMap = new TreeMap<>(map);
        map = treeMap.descendingMap();
        return map;
    }

    /**
    * @Description: object转Byte[]
    * @Param: object
    * @return: byte[]
    * @Author: zhaodahai
    * @Date: 2018/6/12
    */
    public static byte[] objectToByteArray(Object object){
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("对象转数组异常");
        }finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    logger.info("关闭objectOutputStream异常 " + e);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    logger.info("关闭byteArrayOutputStream异常" + e);
                }
            }
        }
        return bytes;
    }

    /**
    * @Description:  byte数组转对象
    * @Param:  bytes
    * @return:  Object
    * @Author: zhaodahai
    * @Date: 2018/6/12
    */
    public static Object byteArrayToObject(byte[] bytes){
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (IOException e) {
            logger.info("数组转对象失败:" + e);
        } catch (ClassNotFoundException e) {
            logger.info("数组转对象异常：" + e);
        }finally {
            if (byteArrayInputStream != null){
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    logger.info("关闭byteArrayInputStream异常:"+ e);
                }
            }
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    logger.info("关闭objectInputStream异常:" + e);
                }
            }
        }
        return object;
    }

}
