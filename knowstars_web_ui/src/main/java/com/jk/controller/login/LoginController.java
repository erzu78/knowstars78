package com.jk.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    //跳转用户查询页面
    @RequestMapping("toUserShow")
    public String toUserShow(){
        return "login/UserShow";
    }

    //跳转登录页面
    @RequestMapping("toLoginShow")
    public String toLoginShow(){
        return "login/UserLogin";
    }

    //跳转用户注册页面
    @RequestMapping("toaddLoginUser")
    public String toaddLoginUser(){
        return "login/addLoginUser";
    }
}
