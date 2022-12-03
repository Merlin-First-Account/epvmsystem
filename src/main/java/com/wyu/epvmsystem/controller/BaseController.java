package com.wyu.epvmsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-18:25
 * @Description
 */
@Controller
public class BaseController {

    @GetMapping("/activityDeleteAdmin")
    public String activityDeleteAdmin(){
        return "activityDeleteAdmin";
    }
    @GetMapping("/activityDeleteRecruiters")
    public String activityDeleteRecruiters(){
        return "activityDeleteRecruiters";
    }
    @GetMapping("/updateActivityPage")
    public String updateActivityPage(){
        return "activityUpdate";
    }
    @GetMapping("/activityAdd")
    public String activityAdd(){
        return "activityAdd";
    }
    @GetMapping("/admins")
    public String admins(){
        return "admins";
    }
    @GetMapping("/mainPage")
    public String mainPage(){
        return "mainPage";
    }
    @GetMapping("/recruiters")
    public String recruiters(){
        return "recruiters";
    }
    @GetMapping("/volunteers")
    public String volunteers(){
        return "volunteers";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/recruitersInfo")
    public String recruitersInfo(){
        return "recruitersInfo";
    }
    @GetMapping("/updatePasswordRecruiters")
    public String updatePasswordRecruiters(){
        return "updatePasswordRecruiters";
    }

}
