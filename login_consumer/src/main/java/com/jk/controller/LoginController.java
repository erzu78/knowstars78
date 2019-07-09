package com.jk.controller;

import com.jk.cliservice.CliService;
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
    @RequestMapping(value="login")
    public String login(User loginuser){
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


}
