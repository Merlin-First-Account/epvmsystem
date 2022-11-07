package com.wyu.epvmsystem;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/5-12:21
 * @Description
 */
public class DateTimeTest {

    @Test
    public void testDate(){
        Date btime = new Date("Fri Nov 18 17:00:00 CST 2022");
        Date etime = new Date("Fri Nov 18 19:30:00 CST 2022");
        System.out.println(btime.getTime()+" "+ etime.getTime());
        double atime = (etime.getTime()-btime.getTime())/60.0/60.0/1000.0;
        String s = new DecimalFormat("#.0").format(atime);//保留一位小数
        String[] split = s.split("\\.");
        int s1 = Integer.parseInt(split[1]);//判断留下的小数
        if (s1>0&&s1<=5){//超过但不满半小时按半小时算 满半小时按一小时算
            s=split[0]+"."+"5";
        }else if (s1 >5){
            s=(Integer.parseInt(split[0])+1)+".0";
        }
        double result = Double.parseDouble(s);
        System.out.println(result);
    }
}
