package cn.youzule.demo.utils.encrypt;

/**
 * @title:进制转换
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/2 23:06
 **/

public class ByteTo {

    /**
    * @Description: 二进制转16进制字符川
    * @Param: byte[]
    * @return: String
    * @Author: zhaodahai
    * @Date: 2018/5/2
    */
    public static String byteToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(bytes[i] & 0xFF);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

}
