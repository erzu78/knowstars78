package com.jk.controller.NewsFlash;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationHref {



    //跳转 快讯展示页面
    @RequestMapping("/toNewsFlash")
    public String toNewsFlash(){
        return "/NewsFlash/shownews";
    }

    @RequestMapping("/addDialogNews")

    public String addDialogNews(){

        return "/NewsFlash/addnews";
    }


    @RequestMapping("/updDialogNews")

    public String updDialogNews(){

        return "/NewsFlash/updatenews";
    }








//跳转首页 快讯专栏
    @RequestMapping("/toNewsFlashPage")

    public String toNewsFlashPage(){

        return "/NewsFlash/NewsFlashPage";
    }

}
