package com.wyu.epvmsystem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.pojo.Volunteer;
import com.wyu.epvmsystem.util.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EpvmsystemApplicationTests {

    @Autowired
    BaseMapper<Volunteer> baseMapper;

    @Test
    void contextLoads() {
//        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("ad_name","admin");
//        System.out.println(MD5.encrypt("admin"));
//        queryWrapper.eq("ad_password", MD5.encrypt("admin"));
//        System.out.println(baseMapper.selectOne(queryWrapper));
//        Admin admin = baseMapper.selectOne(queryWrapper);
        //System.out.println(admin);
    }

    @Test
    void test(){
        QueryWrapper<Volunteer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_id","3119000635");
        System.out.println(MD5.encrypt("admin"));
        queryWrapper.eq("v_password", MD5.encrypt("admin"));
        System.out.println(baseMapper.selectOne(queryWrapper));
    }

}
