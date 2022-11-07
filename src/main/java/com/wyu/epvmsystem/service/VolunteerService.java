package com.wyu.epvmsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.epvmsystem.pojo.LoginForm;
import com.wyu.epvmsystem.pojo.Volunteer;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:38
 * @Description
 */
public interface VolunteerService extends IService<Volunteer> {
    Volunteer login(LoginForm loginForm);

    Volunteer getVolunteerById(Long userId);
}
