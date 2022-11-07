package com.wyu.epvmsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.epvmsystem.mapper.VolunteerMapper;
import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.pojo.LoginForm;
import com.wyu.epvmsystem.pojo.Volunteer;
import com.wyu.epvmsystem.service.VolunteerService;
import com.wyu.epvmsystem.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:39
 * @Description
 */
@Service
@Transactional
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements VolunteerService {

    @Override
    public Volunteer login(LoginForm loginForm) {
        QueryWrapper<Volunteer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_id",loginForm.getLoginUsername());
        queryWrapper.eq("v_password", MD5.encrypt(loginForm.getLoginPassword()));
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Volunteer getVolunteerById(Long userId) {
        return baseMapper.selectById(userId);
    }
}
