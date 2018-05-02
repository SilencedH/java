package cn.youzule.demo.utils.encrypt;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class ByteToTest {

    @Test
    public void test1() throws UnsupportedEncodingException {
        String a = "核力量";
        byte[] bytes = a.getBytes();
        for (int i = 0; i < a.length(); i ++){
            System.out.println(bytes[i]);
        }
        System.out.println("========================");
        String bb = ByteTo.byteToString(bytes);
        System.out.println(bb);
        System.out.println(new String(bytes,"utf-8"));
    }
}
