package net.youzule.youzule.utils.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @title:http工具
 * @description:http工具
 * @company:
 * @author:zhaodahai
 * @date:2018/5/18 11:55
 **/

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String get(String path) {
        URL url = null;
        HttpURLConnection httpConnection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            url = new URL(path);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);
            httpConnection.setRequestMethod("GET");
            httpConnection.setUseCaches(false);
            httpConnection.setRequestProperty("charset", "utf-8");
            httpConnection.connect();

            inputStream = httpConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(readLine);
            }
            return stringBuffer.toString();
        } catch (MalformedURLException e) {
            logger.info("httpUtil异常:{}", e);
            return "999";
        } catch (IOException e) {
            logger.info("httpUtil异常:{}", e);
            return "999";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.info("httpUtil关闭BufferedReader异常:{}", e);
                    return "999";
                }

            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    logger.info("httpUtil关闭inputStreamReader异常:{}", e);
                    return "999";
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.info("httpUtil关闭inputStream异常:{}", e);
                    return "999";
                }
            }
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        }
    }

    /**
     * @Description: 将对象转为get方法参数
     * @Param: Object
     * @return: String
     * @Author: zhaodahai
     * @Date: 2018/5/21
     */

    public static String obj2Str(Object obj) {
        return null;
    }


}
