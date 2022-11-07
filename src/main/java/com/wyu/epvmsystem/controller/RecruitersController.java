package com.wyu.epvmsystem.controller;

import com.wyu.epvmsystem.pojo.Recruiters;
import com.wyu.epvmsystem.service.RecruitersService;
import com.wyu.epvmsystem.util.MD5;
import com.wyu.epvmsystem.util.Result;
import com.wyu.epvmsystem.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/7-10:44
 * @Description
 */
@RestController
@RequestMapping("/recruitersManager")
public class RecruitersController {

    @Autowired
    private RecruitersService recruitersService;

    //此方法是招募者更新个人信息数据，只能更新姓名、性别、学院、电话四个字段
    @PutMapping("/updateRecruitersInfo")
    public Result updateRecruitersInfo(@RequestBody Recruiters recruiters){
        Integer sex = recruiters.getSex();
        String department = recruiters.getDepartment();
        String phone = recruiters.getPhone();

        //校验传过来的参数
        //校验性别
        if (sex!=0&&sex !=1){
            return Result.build(null, ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        //校验院系
        switch (department){
            case  "智能制造学部":
            case  "经济管理学院":
            case  "政法学院":
            case  "马克思主义学院":
            case  "文学院":
            case  "外国语学院":
            case  "数学与计算科学学院":
            case  "应用物理与材料学院":
            case  "土木建筑学院":
            case  "生物科技与大健康学院":
            case  "纺织材料与工程学院":
            case  "轨道交通学院":
            case  "艺术设计学院":
            case  "现代工业生产技术综合训练中心":
            case  "通识教育学院":
            case  "体育部":
            case  "研究生学院":
            case  "继续教育学院":
                break;
            default:
                return Result.build(null, ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        //校验手机
        for (int i=0;i<phone.length();i++){
            if (!Character.isDigit(phone.charAt(i))){
                return Result.build(null, ResultCodeEnum.ARGUMENT_VALID_ERROR);
            }
        }


        //更新招募者数据,只更新特定字段
        boolean update = recruitersService.updateRecruitersInfo(recruiters);
        if (update){
            return Result.ok();
        }
        return Result.fail();
    }


    //此方法是招募者更新登陆密码
    @PutMapping("/updatePasswordRecruiters/{rid}")
    public Result updatePasswordRecruiters(@PathVariable Integer rid,@RequestBody Map<String,String> passwordObj){
        //校验密码
        String oldPassword = passwordObj.get("old");
        Recruiters recruiters= recruitersService.getRecruitersById((long) rid);
        //原密码不正确
        if(!recruiters.getRPassword().equals(MD5.encrypt(oldPassword))){
            Result.build(null,ResultCodeEnum.LOGIN_ERROR);
        }
        //新密码验证不一致
        if(!passwordObj.get("new").equals("confirm")){
            Result.build(null,ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        //没问题就更新数据
        recruiters.setRPassword(MD5.encrypt(passwordObj.get("new")));
        recruitersService.updateById(recruiters);
        return Result.ok();
    }
}
