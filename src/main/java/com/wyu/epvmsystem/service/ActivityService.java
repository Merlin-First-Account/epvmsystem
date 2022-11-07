package com.wyu.epvmsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.epvmsystem.pojo.Activity;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:29
 * @Description
 */
public interface ActivityService extends IService<Activity> {
    IPage<Activity> getActivityByOpr(Page<Activity> page, String activityName);

    IPage<Activity> getActivityByOpr1(Page<Activity> page, String activityName, Integer rid);
}
