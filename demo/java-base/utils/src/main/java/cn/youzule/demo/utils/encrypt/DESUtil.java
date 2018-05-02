package cn.youzule.demo.utils.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.util.Base64;

/**
 * @title:des工具类
 * @description:des工具类
 * @company:
 * @author:zhaodahai
 * @date:2018/5/2 22:18
 **/

public class DESUtil {
    //key,根据需求修改
    public static final String DES_KEY= "12345678";
    //des工作模式，填充方式，ecb模式不用偏移量
    public static final String DES_INSTANCE = "DES/CBC/PKCS5Padding";

    //base64解码编码
    public static Base64.Decoder decoder = Base64.getDecoder();
    public static Base64.Encoder encoder = Base64.getEncoder();

    /**
    * @Description: des加密
    * @Param: byte[]
    * @return: byte[]
    * @Author: zhaodahai
    * @Date: 2018/5/2
    */
    public static byte[] desEncrypt(byte[] data,byte[] key){
        try {
            //初始化偏移量,可以根据需求定义
            IvParameterSpec iv = new IvParameterSpec(key);
            //生产密钥，通过密钥工厂
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            //Cipher对象完成实际加密操作
            Cipher cipher = Cipher.getInstance(DES_INSTANCE);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey,iv);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
    * @Description: des解密
    * @Param: byte[]
    * @return: byte[]
    * @Author: zhaodahai
    * @Date: 2018/5/2
    */
    public static byte[] desDecrypt(byte[] data,byte[] key){
        try {
            IvParameterSpec iv = new IvParameterSpec(key);
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

            Cipher cipher = Cipher.getInstance(DES_INSTANCE);
            cipher.init(Cipher.DECRYPT_MODE,secretKey,iv);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
    * @Description: des加密，base64编码
    * @Param: String
    * @return: String
    * @Author: zhaodahai
    * @Date: 2018/5/2
    */
    public static String desEncryptBase64(String data,String key){
        //des加密
        byte[] bytes = desEncrypt(data.getBytes(),key.getBytes());
        return encoder.encodeToString(bytes);
    }

    /**
    * @Description: base64解码，des解密
    * @Param: String
    * @return: String
    * @Author: zhaodahai
    * @Date: 2018/5/2
    */
    public static String desDecrypt(String data,String key){
        //base64解码
        byte[] bytes = decoder.decode(data);
        //des解密
        byte[] bytes1 = desDecrypt(data.getBytes(),key.getBytes());
        try {
            String result = new String(bytes1,"utf-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
