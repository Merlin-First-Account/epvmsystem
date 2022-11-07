package com.wyu.epvmsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    //此方法是招募者更新个人信息数据，只能更新姓名、性别、学院、电话四个字段
    @Override
    public boolean updateRecruitersInfo(Recruiters recruiters) {
        UpdateWrapper<Recruiters> uw = new UpdateWrapper<>();
        //条件
        uw.eq("r_id",recruiters.getRId());
        //字段
        uw.set("r_name",recruiters.getRName());
        uw.set("sex",recruiters.getSex());
        uw.set("department",recruiters.getDepartment());
        uw.set("phone",recruiters.getPhone());
        try {
            //要uw.getEntity(),不然password会变为空值,因为前端发回来的招募者信息没有密码
            baseMapper.update(uw.getEntity(), uw);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
