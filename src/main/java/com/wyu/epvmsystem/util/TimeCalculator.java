package com.wyu.epvmsystem.util;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/5-12:45
 * @Description
 */
public class TimeCalculator {
    public static Double calculateTime(Date btime,Date etime){
        double atime = (etime.getTime()-btime.getTime())/60.0/60.0/1000.0;
        String s = new DecimalFormat("#.0").format(atime);//保留一位小数，不足时补0
        System.out.println(s);
        String[] split = s.split("\\.");
        int s1 = Integer.parseInt(split[1]);//判断留下的小数
        if (s1>0&&s1<=5){//超过但不满半小时按半小时算 满半小时按一小时算
            s=split[0]+"."+"5";
        }else if (s1 >5){
            s=(Integer.parseInt(split[0])+1)+".0";
        }
        return Double.parseDouble(s);
    }
}
