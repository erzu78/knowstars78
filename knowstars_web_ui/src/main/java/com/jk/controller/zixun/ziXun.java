package com.jk.controller.zixun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ziXun {
    @RequestMapping("/tonfo")
    //跳到前台展示页面
    public String toInfo(){
     return "zixun/userShow";
    }
    @RequestMapping("/addDialogInfo")
    //跳转到添加页面
    public String addDialogInfo(){
        return "zixun/toAddInfo";
    }
}
