package com.jk.controller;

import com.jk.cliservice.CliService;
import com.jk.pojo.Staff;
import com.jk.pojo.User;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    private CliService cliService;

    @Autowired
    private LoginService loginService;

    //用户登录页面
    @RequestMapping(value="loginuser")
    public String loginuser(User loginuser){
        User userModel=loginService.login(loginuser);
        if(userModel!=null){
            return "1";
        }else{
            return "2";
        }
    }

    //用户注册
    @RequestMapping("addLoginUser")
    public String addLoginUser(User loginuser) {
        String str = loginService.addLoginUser(loginuser);
        return str;
    }

    //用户查询页面
    @RequestMapping("findUser")
    public HashMap<String,Object> findUser(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize){
        HashMap<String,Object> hashMap=loginService.findUser(start,pageSize);
        return hashMap;
    }

    //用户删除
    @RequestMapping("delOne")
    public String delOne(@RequestParam("uid")Integer uid){
        loginService.delOne(uid);
        return null;
    }

   //员工登录页面
    @RequestMapping(value="loginstaff")
    public String loginstaff(Staff loginstaff){
        User userModel=loginService.loginstaff(loginstaff);
        if(userModel!=null){
            return "1";
        }else{
            return "2";
        }
    }

    //员工注册
    @RequestMapping("addLoginStaff")
    public String addLoginStaff(Staff loginstaff) {
        String str = loginService.addLoginStaff(loginstaff);
        return str;
    }

    //员工查询页面
    @RequestMapping("findStaff")
    public HashMap<String,Object> findStaff(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize){
        HashMap<String,Object> hashMap=loginService.findStaff(start,pageSize);
        return hashMap;
    }

}
