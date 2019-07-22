package com.jk.controller.NewsFlash;
import	java.lang.reflect.Modifier;
import	java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationHref {



    //跳转 快讯展示页面
    @RequestMapping("/toNewsFlash")
    public String toNewsFlash(){
        return "/NewsFlash/shownews";
    }
     //快讯后台添加弹框
    @RequestMapping("/addDialogNews")

    public String addDialogNews(){

        return "/NewsFlash/addnews";
    }

 //快讯后台修改弹框
    @RequestMapping("/updDialogNews")

    public String updDialogNews(){

        return "/NewsFlash/updatenews";
    }








//首页 快讯专栏  点击标题 跳转到对应的快讯内容（右下角）
    @RequestMapping("/toNewsFlashPage")

    public String toNewsFlashPage(Integer newsid, Model model){

        model.addAttribute("newsid",newsid);
        return "/NewsFlash/NewsFlashPage";
    }








    //跳转首页 快讯专栏
    @RequestMapping("/toNewsFlashAll")

    public String toNewsFlashAll(Integer newsAllid,Model model){
    model.addAttribute("newsAllid",newsAllid);
        return "/NewsFlash/NewsFlashAll";
    }





}
