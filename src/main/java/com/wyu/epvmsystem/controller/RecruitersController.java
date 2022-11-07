package com.wyu.epvmsystem.controller;

import com.wyu.epvmsystem.util.Result;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/7-10:44
 * @Description
 */
@RestController
@RequestMapping("/recruitersManager")
public class RecruitersController {
    @PutMapping("/updateRecruitersInfo")
    public Result updateRecruitersInfo(@PathParam("rid")Integer rid){
        System.out.println(rid);
        System.out.println(rid);
        return Result.ok();
    }
}
