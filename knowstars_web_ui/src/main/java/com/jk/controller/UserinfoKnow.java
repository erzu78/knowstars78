package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @title: UserinfoKnow
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000921:25
 */
@Controller
public class UserinfoKnow {
    //跳转个人信息页面
    @RequestMapping("toUserinfo")
    public String toUserinfo(){

        return "userinfo/userinfoShow";
    }
}
