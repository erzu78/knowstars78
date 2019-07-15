package com.jk.controller.zixun;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("updDialogInfo")
    public String updDialogInfo(){
        return "zixun/toUpInfo";
    }
    @RequestMapping("/toAllZx")
    public String toAllZx(){
        return "zixun/toAllZx";
    }
    @RequestMapping("/tz")
    public String tz(@RequestParam("tid") Integer tid,Model model){
        model.addAttribute("tid",tid);
        return "zixun/tz";
    }
    @RequestMapping("/toTy")
    public String toTy(){
        return "zixun/toTy";
    }
    @RequestMapping("/addDialogTy")
    //跳转到添加页面
    public String addDialogTy(){

        return "zixun/toAddTy";
    }
    @RequestMapping("updDialogTy")
    public String updDialogTy(){

        return "zixun/toUpTy";
    }
}
