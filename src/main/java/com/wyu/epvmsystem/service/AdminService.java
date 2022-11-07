package com.wyu.epvmsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.pojo.LoginForm;
import org.springframework.stereotype.Service;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/2-18:38
 * @Description
 */
public interface AdminService extends IService<Admin> {
    Admin login(LoginForm loginForm);

    Admin getAdminById(Long userId);
}
