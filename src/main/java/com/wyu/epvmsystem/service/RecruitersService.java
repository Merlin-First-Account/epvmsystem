package com.wyu.epvmsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.epvmsystem.pojo.LoginForm;
import com.wyu.epvmsystem.pojo.Recruiters;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:36
 * @Description
 */
public interface RecruitersService extends IService<Recruiters> {
    Recruiters login(LoginForm loginForm);

    Recruiters getRecruitersById(Long userId);

    boolean updateRecruitersInfo(Recruiters recruiters);
}
