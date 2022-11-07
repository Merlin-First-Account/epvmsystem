package com.wyu.epvmsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.epvmsystem.mapper.AdminMapper;
import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.pojo.LoginForm;
import com.wyu.epvmsystem.service.AdminService;
import com.wyu.epvmsystem.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/2-18:39
 * @Description
 */
@Service("adminServiceImpl")
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{
    @Override
    public Admin login(LoginForm loginForm) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ad_name",loginForm.getLoginUsername());
        queryWrapper.eq("ad_password", MD5.encrypt(loginForm.getLoginPassword()));
        Admin admin = baseMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public Admin getAdminById(Long userId) {
       return baseMapper.selectById(userId);
    }
}
