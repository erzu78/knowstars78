package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.*;
import com.jk.pojo.Infotype;
import com.jk.service.HomePageService;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomePageControllerCon {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HomePageService homePageService;
    @RequestMapping("queryImg")
    @ResponseBody
    public List<Img>  queryImg(){
        List<Img> ilist= homePageService.queryImg();
       /* System.out.println(ilist);*/
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
    @RequestMapping("/queryZiXun")
    @ResponseBody
    public List<Infotype> queryZiXun(){
        List<Infotype> ilist= homePageService.queryZiXun();
        System.out.println(ilist);
        return ilist;
    }

    @RequestMapping("queryTree")
    @ResponseBody
    public List<MenuTree> getTreeAll(){
        List<MenuTree> list = homePageService.queryTree();
        list =  TreeNoteUtil.getFatherNode(list);
        return list;

    }


    @RequestMapping("queryLoginById")
    @ResponseBody
    public Staff queryLoginById(){

        String staffString = (String) redisTemplate.opsForValue().get("staffjs");
        Staff staff = JSONObject.parseObject(staffString, Staff.class);

        if(staff!=null){
            return staff;
        }else{
            return null;
        }


    }





}
