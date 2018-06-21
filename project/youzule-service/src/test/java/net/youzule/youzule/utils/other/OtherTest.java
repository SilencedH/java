package net.youzule.youzule.utils.other;

import org.junit.Test;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/8 19:14
 **/

public class OtherTest {

    public void throwException(){
        try {
            int i = 1 / 0;

        }catch (Exception e){
        e.printStackTrace();
        }
    }

    @Test
    public void test(){
        System.out.println("start");
        outer();
        System.out.println("end");
    }


    public void outer(){
        System.out.println("outer start");
        throwException();
        System.out.println("outer end");
    }
}
