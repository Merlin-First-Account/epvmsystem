package com.wyu.epvmsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyu.epvmsystem.pojo.Admin;
import com.wyu.epvmsystem.pojo.LoginForm;
import com.wyu.epvmsystem.pojo.Recruiters;
import com.wyu.epvmsystem.pojo.Volunteer;
import com.wyu.epvmsystem.service.AdminService;
import com.wyu.epvmsystem.service.RecruitersService;
import com.wyu.epvmsystem.service.VolunteerService;
import com.wyu.epvmsystem.util.CreateVerifiCodeImage;
import com.wyu.epvmsystem.util.JwtHelper;
import com.wyu.epvmsystem.util.Result;
import com.wyu.epvmsystem.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/1-20:51
 * @Description
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RecruitersService recruitersService;
    @Autowired
    private VolunteerService volunteerService;

    @RequestMapping("/getVerifyCode")
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response){
        //获取图片
        BufferedImage codeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        //获取验证码文字
        String code = new String(CreateVerifiCodeImage.getVerifiCode());
        //放到请求域
        HttpSession session = request.getSession();
        session.setAttribute("VerifyCode",code);
        //传送验证码图片
        try {
            ImageIO.write(codeImage,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        String code = (String) request.getSession().getAttribute("VerifyCode");
        try {
            response.getWriter().write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm,HttpServletRequest request){
        HttpSession session = request.getSession();
        String verifyCode = loginForm.getVerifyCode();
        //验证码校验
        if (verifyCode == null|| verifyCode .equals("")){
           return Result.fail().message("验证码不能为空");
        }
        String sessionVerifyCode = session.getAttribute("VerifyCode").toString().toUpperCase();
        if (!verifyCode.equals(sessionVerifyCode)){
            return Result.fail().message("验证码错误");
        }
        //移除session里面的验证码
        session.removeAttribute("VerifyCode");

        //按照角色跳转页面
        Map<String,Object> map=new LinkedHashMap<>();
        switch (loginForm.getAuthType()){
            case 0:
                try {
                    Admin admin = adminService.login(loginForm);
                    if (null != admin) {
                        // 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
                        map.put("token", JwtHelper.createToken(admin.getAdId().longValue(), 0));
                    }else{
                        throw new RuntimeException("用户名或者密码有误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case 1:
                try {
                    Recruiters recruiter = recruitersService.login(loginForm);
                    if (null != recruiter) {
                        // 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
                        map.put("token", JwtHelper.createToken(recruiter.getRId().longValue(), 1));
                    }else{
                        throw new RuntimeException("用户名或者密码有误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case 2:
                try {
                    Volunteer volunteer = volunteerService.login(loginForm);
                    if (null != volunteer) {
                        // 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
                        map.put("token", JwtHelper.createToken(volunteer.getVId().longValue(), 2));
                    }else{
                        throw new RuntimeException("用户名或者密码有误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
        }
        return Result.fail().message("查无此用户");
    }

    @GetMapping("/getInfo")
    public Result getInfoByToken(@RequestHeader("token") String token){
        boolean expiration = JwtHelper.isExpiration(token);
        //检测token是不是过期了
        if(expiration){
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        Long userId = JwtHelper.getUserId(token);
        Integer userType = JwtHelper.getUserType(token);
        Map<String,Object> map = new HashMap<>();
        switch (userType){
            case 0:
                Admin admin = adminService.getAdminById(userId);
                map.put("userType",userType);
                admin.setAdPassword("");
                map.put("user",admin);
                break;
            case 1:
                Recruiters recruiters = recruitersService.getRecruitersById(userId);
                map.put("userType",userType);
                recruiters.setRPassword("");
                map.put("user",recruiters);
                break;
            case 2:
                Volunteer volunteer = volunteerService.getVolunteerById(userId);
                map.put("userType",userType);
                volunteer.setVPassword("");
                map.put("user",volunteer);
                break;
        }
        return Result.ok(map);
    }
}