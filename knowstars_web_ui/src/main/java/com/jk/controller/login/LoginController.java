package com.jk.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    //跳转用户查询页面
    @RequestMapping("toUserShow")
    public String toUserShow(){ return "login/UserShow"; }

    //跳转员工查询页面
    @RequestMapping("toStaffShow")
    public String toStaffShow(){
        return "login/StaffShow";
    }

    //跳转用户登录页面
    @RequestMapping("toUserLogin")
    public String toUserLogin(){
        return "login/UserLogin";
    }

    //跳转用户注册页面
    @RequestMapping("toaddLoginUser")
    public String toaddLoginUser(){
        return "login/addLoginUser";
    }

    //跳转员工登录页面
    @RequestMapping("toStaffLogin")
    public String toStaffLogin(){
        return "login/StaffLogin";
    }

    //跳转员工注册页面
    @RequestMapping("toaddLoginStaff")
    public String toaddLoginStaff(){
        return "login/addLoginStaff";
    }

    //跳转员工注册页面
    @RequestMapping("touserinfo")
    public String touserinfo(){
        return "userinfo/userinfoShow";
    }



}
