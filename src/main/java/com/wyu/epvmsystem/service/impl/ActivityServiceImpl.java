package com.wyu.epvmsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyu.epvmsystem.mapper.ActivityMapper;
import com.wyu.epvmsystem.pojo.Activity;
import com.wyu.epvmsystem.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:28
 * @Description
 */
@Service("activityServiceImpl")//定义当前实现类的id
@Transactional
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper,Activity> implements ActivityService {//ServiceImpl已经实现了一些IService里面的抽象方法
    @Override
    public IPage<Activity> getActivityByOpr(Page<Activity> pageParam, String activityName) {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(activityName)){
            queryWrapper.like("a_name",activityName);
        }
        queryWrapper.orderByDesc("a_id");
        Page<Activity> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }

    @Override
    public IPage<Activity> getActivityByOpr1(Page<Activity> pageParam, String activityName, Integer rid) {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(activityName)){
            queryWrapper.like("a_name",activityName);
        }
        queryWrapper.eq("r_id",rid);
        queryWrapper.orderByDesc("a_id");
        Page<Activity> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }

}
