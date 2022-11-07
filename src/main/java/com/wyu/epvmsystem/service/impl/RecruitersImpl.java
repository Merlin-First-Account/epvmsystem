package com.wyu.epvmsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.epvmsystem.mapper.RecruitersMapper;
import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.pojo.LoginForm;
import com.wyu.epvmsystem.pojo.Recruiters;
import com.wyu.epvmsystem.service.RecruitersService;
import com.wyu.epvmsystem.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:37
 * @Description
 */
@Service
@Transactional
public class RecruitersImpl extends ServiceImpl<RecruitersMapper, Recruiters> implements RecruitersService {

    @Override
    public Recruiters login(LoginForm loginForm) {
        QueryWrapper<Recruiters> qr = new QueryWrapper<>();
        qr.eq("w_id",loginForm.getLoginUsername());
        qr.eq("r_password", MD5.encrypt(loginForm.getLoginPassword()));
        return baseMapper.selectOne(qr);
    }

    @Override
    public Recruiters getRecruitersById(Long userId) {
        return  baseMapper.selectById(userId);
    }

}
