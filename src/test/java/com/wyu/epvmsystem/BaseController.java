package com.wyu.epvmsystem;

import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/3-11:43
 * @Description
 */
@SpringBootTest
public class BaseController {

    @Autowired
    private AdminService adminService;
    @Test
    public void testMethod(){
        Admin admin = adminService.getAdminById(1L);
        System.out.println(admin);
    }

}
