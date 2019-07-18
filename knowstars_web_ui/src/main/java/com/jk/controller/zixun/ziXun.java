package com.jk.controller.zixun;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "zixun/toAllZxx";
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
    @RequestMapping("toWz")
    public String toWz(@RequestParam Integer infid,Model model){
        model.addAttribute("infid",infid);
        return "zixun/toWz";
    }
    @RequestMapping("toAllWz")
    public String toAllWz(@RequestParam Integer infid,Model model){
        System.out.println(infid);
        model.addAttribute("infid",infid);
        return "zixun/toAllWz";
    }
    @RequestMapping("toAllWzz")
    public String toAllWzz(@RequestParam Integer sid,Model model){
        System.out.println(sid);
        model.addAttribute("sid",sid);
        return "zixun/toAllWz";
    }
    @RequestMapping("toTopicWz")
    public String toTopicWz(@RequestParam Integer topicid,Model model){
        System.out.println(topicid);
        model.addAttribute("topicid",topicid);
        return "zixun/toTopicWz";
    }
    @RequestMapping("toAllTopic")
    public String toAllTopic(){
        return "zixun/AllTopic";
    }
}
