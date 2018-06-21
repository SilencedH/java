package net.youzule.youzule.utils.stream;

import org.junit.Test;

import static org.junit.Assert.*;

public class StreamUtilTest {

    @Test
    public void test1(){
        String path = "src/main/resources/application.yml";
        String result = StreamUtil.readFile(path);
        System.out.println(result);

    }

}