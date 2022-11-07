package com.wyu.epvmsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyu.epvmsystem.pojo.Activity;
import com.wyu.epvmsystem.service.ActivityService;
import com.wyu.epvmsystem.util.Result;
import com.wyu.epvmsystem.util.ResultCodeEnum;
import com.wyu.epvmsystem.util.TimeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/1-20:48
 * @Description
 */
@RestController
@RequestMapping("/activityManager")
public class ActivityController {


    @Autowired
    ActivityService activityService;


    //增加或者更新功能
    @PostMapping("/saveOrUpdateActivity")
    public Result saveOrUpdateActivity(@RequestBody Activity activity){
        //检测活动的开始时间和结束时间是否有问题，并且计算活动义工时
        Date bTime = activity.getBTime();
        Date eTime = activity.getETime();
        if (!bTime.before(eTime) || bTime.equals(eTime)){//开始时间要早于结束时间
            return Result.build(null, ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        if (activity.getAPoint()<=0 || activity.getVQuantity() <=0){//积分或者招募人数小于等于0
            return Result.build(null, ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        activity.setATime(TimeCalculator.calculateTime(bTime,eTime));//计算义工时
        activityService.saveOrUpdate(activity);
        return Result.ok();
    }


    //活动删除功能单选+批量
    @DeleteMapping("/deleteActivityByAid")
    public Result deleteActivityByAid(
            @RequestBody List<Integer> ids
    ){
        activityService.removeByIds(ids);
        return Result.ok();
    }

    //获取数据支持模糊查询 管理员页面
    // sms/clazzController/getClazzsByOpr/1/3?gradeName=&name=
    @GetMapping("/getActivityByOpr")
    public Result getClazzByOpr(
            @PathParam("pageNo") Integer pageNo,
            @PathParam("pageSize") Integer pageSize,
            String activityName
    ){
        System.out.println(activityName);
        Page<Activity> page =new Page<>(pageNo,pageSize);

        IPage<Activity> iPage=activityService.getActivityByOpr(page,activityName);
        return Result.ok(iPage);

    }

    //获取数据支持模糊查询 招募者页面 加一个rid的查询条件
    // sms/clazzController/getClazzsByOpr/1/3?gradeName=&name=
    @GetMapping("/getActivityByOpr1")
    public Result getClazzByOpr1(
            @PathParam("pageNo") Integer pageNo,
            @PathParam("pageSize") Integer pageSize,
            @PathParam("rid") Integer rid,
            String activityName
    ){
        System.out.println(rid);
        Page<Activity> page =new Page<>(pageNo,pageSize);

        IPage<Activity> iPage=activityService.getActivityByOpr1(page,activityName,rid);
        return Result.ok(iPage);

    }

    //志愿者获取活动的粗略信息


}
