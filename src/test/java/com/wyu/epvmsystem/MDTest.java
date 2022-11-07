package com.wyu.epvmsystem;

import com.wyu.epvmsystem.util.MD5;
import org.junit.jupiter.api.Test;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/3-17:34
 * @Description
 */
public class MDTest {
    @Test
    void test(){
        String s = MD5.encrypt("aa123456");
        System.out.println(s);
    }
}
