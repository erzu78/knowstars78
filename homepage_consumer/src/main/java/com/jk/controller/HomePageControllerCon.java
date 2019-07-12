package com.jk.controller;

import com.jk.pojo.Img;
import com.jk.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomePageControllerCon {
    @Autowired
    private HomePageService homePageService;
    @RequestMapping("/queryImg")
    @ResponseBody
    public List<Img>  queryImg(){
        List<Img> ilist= homePageService.queryImg();
        System.out.println(ilist);
        return ilist;
    }
    @RequestMapping("/queryTabs")
    @ResponseBody
    public List<Img> queryTabs(){
        List<Img> ilist= homePageService.queryImg();
        System.out.println(ilist);
        return ilist;
    }
    @RequestMapping("queryImg1")
    public String  queryImg1(){
        return "homePage/testMain";
    }
    @RequestMapping("queryImg2")
    public String  queryImg2(){
        return "homePage/pagelov3";
    }
}
