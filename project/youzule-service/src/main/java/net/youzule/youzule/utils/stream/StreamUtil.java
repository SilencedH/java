package net.youzule.youzule.utils.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @title:StreamUtil
 * @description:流操作
 * @company:
 * @author:zhaodahai
 * @date:2018/5/16 14:21
 **/

public class StreamUtil {

    /**
    * @Description: 从文件中读取内容
    * @Param: String 文件路径
    * @return: String 内容
    * @Author: zhaodahai
    * @Date: 2018/5/16
    */

    public static String readFile(String path){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int size = fileInputStream.available();
            byte[] bytes = new byte[size];
            fileInputStream.read(bytes);
            String result = new String(bytes,"utf-8");
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
