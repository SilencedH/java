package net.youzule.youzule.utils.other;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/13 11:37
 **/

public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                if(i == 9){
                    this.cancel();
                    timer.cancel();
                    System.out.println("cancel");
                }
                i ++;
                System.out.println("hello world" + String.valueOf(i));
            }
        }, new Date(), 1000);
        System.out.println("over");
    }


    @Test
    public void test1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }, 1000);
    }
}
